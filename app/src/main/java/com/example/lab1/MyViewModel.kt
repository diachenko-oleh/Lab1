package com.example.lab1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _homeText = mutableStateOf("MAIN PAGE")
    val homeText: State<String> = _homeText
    fun updateHomeText(newText: String) {
        _homeText.value = newText
    }
}