package com.example.lab1.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lab1.Screens.Page1.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow

class MyViewModel : ViewModel() {
    private val _homeText = mutableStateOf("MAIN PAGE")
    val homeText: State<String> = _homeText
    fun updateHomeText(newText: String) {
        _homeText.value = newText
    }
    private val repo = DataRepository()
    val users = MutableStateFlow(repo.users)
    val spheres = MutableStateFlow(repo.spheres)
}