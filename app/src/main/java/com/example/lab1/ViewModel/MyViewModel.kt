package com.example.lab1.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.lab1.Screens.Page1.DataRepository
import com.example.lab1.Screens.Page1.IListable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MyViewModel : ViewModel() {
    private val _homeText = mutableStateOf("MAIN PAGE")
    val homeText: State<String> = _homeText
    fun updateHomeText(newText: String) {
        _homeText.value = newText
    }

    private val repo : DataRepository = DataRepository()
    private var _megaList: MutableStateFlow<List<IListable>> =
        MutableStateFlow(emptyList())
    val megaList: StateFlow<List<IListable>> = _megaList
    fun getAllData() {
        _megaList.value = repo.getAllData()
    }
}

