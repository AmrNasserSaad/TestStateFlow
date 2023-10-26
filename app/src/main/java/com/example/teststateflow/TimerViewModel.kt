package com.example.teststateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _timerStateFlow: MutableStateFlow<Int> = MutableStateFlow<Int>(0)
    val timerStateFlow: MutableStateFlow<Int> = _timerStateFlow

    fun startTimer() {
        viewModelScope.launch {
            val list = listOf<Int>(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9,10)
            for (i in list) {
                _timerStateFlow.emit(i)
                delay(1000)
            }
        }
    }
}