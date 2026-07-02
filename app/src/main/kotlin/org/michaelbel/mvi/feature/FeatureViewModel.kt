package org.michaelbel.mvi.feature

import kotlinx.coroutines.launch
import org.michaelbel.mvi.feature.event.FeatureEvent
import org.michaelbel.mvi.feature.intent.FeatureIntent
import org.michaelbel.mvi.feature.model.FeatureModel
import org.michaelbel.mvi.mvi.MviViewModel

class FeatureViewModel: MviViewModel<FeatureIntent, FeatureModel, FeatureEvent>(FeatureModel()) {

    init {
        dispatch(FeatureIntent.SetButtonText("Button"))
    }

    override fun dispatch(intent: FeatureIntent) {
        when (intent) {
            is FeatureIntent.SetButtonText -> reduce { it.copy(buttonText = intent.text) }
            is FeatureIntent.OnButtonClick -> launch { push(FeatureEvent.ShowToast("Message")) }
        }
    }
}
