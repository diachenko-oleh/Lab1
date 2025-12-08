package com.example.lab1.Repository

import com.example.lab1.Model.Client
import com.example.lab1.Model.IListable
import com.example.lab1.Model.Table


interface AppRepo {
    fun getClients(): List<Client>
    fun getTables(authors: List<Client>): List<Table>
    suspend fun getAllClients(): List<Client>
    suspend fun getClientById(id: Int): Client
    suspend fun insertAllClients(clients: List<Client>)
    suspend fun insertClient(client: Client)
    suspend fun deleteClient(client: Client)
    suspend fun deleteAllClients()

    suspend fun getAllTables(): List<Table>
    suspend fun getTableById(tableId: Int): Table
    suspend fun getTablesByClientId(clientId: Int): List<Table>
    suspend fun insertAllTables(tables: List<Table>)
    suspend fun insertTable(table: Table)
    suspend fun deleteTable(table: Table)
    suspend fun deleteAllTables()
    suspend fun updateTable(table: Table)
    suspend fun getAllData(): List<IListable>
}