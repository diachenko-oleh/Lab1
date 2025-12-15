package com.example.lab1.Repository

import com.example.lab1.API.RetrofitClient
import com.example.lab1.DAO.AppDAO
import com.example.lab1.Model.Client
import com.example.lab1.Model.ClientList
import com.example.lab1.Model.IListable
import com.example.lab1.Model.Table
import com.example.lab1.Utils.toDomain
import com.example.lab1.Utils.toEntity
import kotlin.collections.map

class AppRepoImpl(private val appDao: AppDAO):AppRepo {

    override suspend fun loadFromApi() {
        val response = RetrofitClient.api.getAllData()

        appDao.deleteAllTables()
        appDao.deleteAllClients()

        appDao.insertAllClients(response.clients.map { it.toEntity() })
        appDao.insertAllTables(response.tables.map { it.toEntity() })
    }

    override suspend fun getMegaListFromDb(): List<IListable> {
        var megaList: List<IListable> = appDao.getAllTables().map { it.toDomain() }
        megaList = megaList.plus(
            ClientList(appDao.getAllClients().map { it.toDomain() })
        )
        megaList = megaList.plus(
            appDao.getAllClients().map { it.toDomain() }
        )
        return megaList
    }

    override suspend fun getAllClients(): List<Client> {
        return appDao.getAllClients().map { it.toDomain() }
    }

    override suspend fun getClientById(id: Int): Client {
        return appDao.getClientById(id).toDomain()
    }

    override suspend fun insertAllClients(clients: List<Client>) {
        appDao.insertAllClients(clients.map { it.toEntity() })
    }

    override suspend fun insertClient(client: Client) {
        appDao.insertClient(client.toEntity())
    }

    override suspend fun deleteClient(client: Client) {
        appDao.deleteClient(client.toEntity())
    }

    override suspend fun deleteAllClients() {
        appDao.deleteAllClients()
    }

    override suspend fun getAllTables(): List<Table> {
        return appDao.getAllTables().map { it.toDomain() }
    }

    override suspend fun getTableById(tableId: Int): Table {
        return appDao.getTableById(tableId).toDomain()
    }

    override suspend fun getTablesByClientId(clientId: Int): List<Table> {
        return appDao.getTablesByClientId(clientId).map { it.toDomain() }
    }

    override suspend fun insertAllTables(tables: List<Table>) {
        appDao.insertAllTables(tables.map { it.toEntity() })
    }

    override suspend fun insertTable(table: Table) {
        appDao.insertTable(table.toEntity())
    }

    override suspend fun deleteTable(table: Table) {
        appDao.deleteTable(table.toEntity())
    }

    override suspend fun deleteAllTables() {
        appDao.deleteAllTables()
    }

    override suspend fun updateTable(table: Table) {
        appDao.updateTable(table.toEntity())
    }
}