package org.michaelbel.mvi.feature

import kotlinx.coroutines.launch
import org.michaelbel.mvi.mvi.MviViewModel

class FeatureViewModel: MviViewModel<FeatureIntent, FeatureModel, FeatureEvents>(FeatureModel()) {

    init {
        dispatch(FeatureIntent.SetButtonText("Button"))
    }

    override fun dispatch(intent: FeatureIntent) {
        when (intent) {
            is FeatureIntent.SetButtonText -> reduce { it.copy(buttonText = intent.text) }
            is FeatureIntent.OnButtonClick -> launch { push(FeatureEvents.ShowToast("Message")) }
        }
    }
}
