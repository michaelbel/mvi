package org.michaelbel.mvi.feature

import org.michaelbel.mvi.mvi.Intent

sealed interface FeatureIntent: Intent {
    data object OnButtonClick: FeatureIntent
    data class SetButtonText(val text: String): FeatureIntent
}
