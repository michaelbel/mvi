package org.michaelbel.mvi.mvi

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

abstract class MviViewModel<I: Intent, M: Model, E: Event>(
    initialState: M
): CoroutineViewModel() {

    private val _stateFlow = MutableStateFlow(initialState)
    val stateFlow: StateFlow<M> = _stateFlow

    private val _eventChannel = Channel<E>()
    val eventFlow: Flow<E> = _eventChannel.receiveAsFlow()

    protected fun reduce(reducer: (M) -> M) {
        _stateFlow.update(reducer)
    }

    protected suspend fun push(event: E) {
        _eventChannel.send(event)
    }

    abstract fun dispatch(intent: I)
}
