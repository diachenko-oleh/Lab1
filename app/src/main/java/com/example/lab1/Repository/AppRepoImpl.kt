package com.example.lab1.Repository

import com.example.lab1.DAO.AppDAO
import com.example.lab1.Model.Client
import com.example.lab1.Model.ClientList
import com.example.lab1.Model.IListable
import com.example.lab1.Model.Table
import com.example.lab1.Utils.toDomain
import com.example.lab1.Utils.toEntity
import kotlin.collections.map

class AppRepoImpl(private val appDao: AppDAO):AppRepo {

    val clientList = listOf(
        Client(
            name = "Client 1",
            email = "email1@gmail.com"
        ),

        Client(
            name = "Client 2",
            email = "email2@gmail.com"
        ),

        Client(
            name = "Client 3",
            email = "email3@gmail.com"
        ),
        Client(
            name = "Client 4",
            email = "email4@gmail.com"
        ),
        Client(
            name = "Client 5",
            email = "email5@gmail.com"
        )
    )

    override fun getClients(): List<Client> {
        return clientList
    }

    override fun getTables(clients: List<Client>): List<Table> {
       return  listOf(
           Table(
               capacity = 2,
               client = clients[0],
           ),
           Table(
               capacity = 2,
               client = clients[1]
           ),
           Table(
               capacity = 2,
               client = clients[1]
           ),
           Table(
               capacity = 4,
               client = clients[2]
           ),
           Table(
               capacity = 4,
               client = clients[3]
           )
       )
    }

    override suspend fun getAllData(): List<IListable> {
        var megaList: List<IListable> = getAllTables()
        megaList = megaList.plus(ClientList(getAllClients()))
        megaList = megaList.plus(getAllClients())
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