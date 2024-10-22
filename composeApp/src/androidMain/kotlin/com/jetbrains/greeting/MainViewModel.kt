package com.jetbrains.greeting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 *
 * @author alkathirikhalid
 * @project GreetingKMP
 * @date 22/10/2024
 */
class MainViewModel : ViewModel() {
    private val _greetingList = MutableStateFlow<List<String>>(listOf())
    val greetingList: StateFlow<List<String>> get() = _greetingList

    init {
        viewModelScope.launch {
            Greeting().greet().collect { phrase ->
                _greetingList.update { list -> list + phrase }
            }
        }
    }
}