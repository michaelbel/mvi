package org.michaelbel.mvi.feature

import org.michaelbel.mvi.mvi.Event

sealed interface FeatureEvents: Event {
    data class ShowToast(val message: String): FeatureEvents
}
