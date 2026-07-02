package org.michaelbel.mvi.feature.event

import org.michaelbel.mvi.mvi.Event

sealed interface FeatureEvent: Event {
    data class ShowToast(val message: String): FeatureEvent
}
