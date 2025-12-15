package com.example.lab1.ViewModel

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab1.Model.Client
import com.example.lab1.Model.IListable
import com.example.lab1.Model.Table
import com.example.lab1.MyApp
import com.example.lab1.Repository.AppRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MyViewModel(application: Application): AndroidViewModel(application) {

    private val repo : AppRepo = (application as MyApp).appRepository
    private val _megaList = MutableStateFlow<List<IListable>>(emptyList())
    val megaList: StateFlow<List<IListable>> = _megaList.asStateFlow()

    private suspend fun updateData(fromApi: Boolean = false) {
        _megaList.value = if (fromApi) {
            repo.loadFromApi()
            repo.getMegaListFromDb()
        } else {
            repo.getMegaListFromDb()
        }
    }

    fun loadAllDataToDb() {
        viewModelScope.launch {
            updateData(fromApi = true)
        }
    }

    fun clearAllDataFromDb() {
        viewModelScope.launch {
            repo.deleteAllTables()
            repo.deleteAllClients()
            _megaList.value = emptyList()
        }
    }

    fun deleteTableFromDb(table: Table) {
        viewModelScope.launch {
            repo.deleteTable(table)
            updateData()
        }
    }

    fun deleteClientFromDb(client: Client) {
        viewModelScope.launch {
            repo.deleteClient(client)
            updateData()
        }
    }

    fun changeTableCapacity(table: Table, delta: Int) {
        val updated = table.copy(capacity = table.capacity + delta)
        viewModelScope.launch {
            repo.updateTable(updated)
            updateData()
        }
    }


    private val _homeText = mutableStateOf("MAIN PAGE")
    val homeText: State<String> = _homeText
    fun updateHomeText(newText: String) {
        _homeText.value = newText
    }
}

