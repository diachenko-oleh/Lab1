package com.example.lab1.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.lab1.Entity.TableEntity
import com.example.lab1.Entity.TableWithClient
import com.example.lab1.Entity.ClientEntity
import com.example.lab1.Model.Client

@Dao
interface AppDAO {

//Users DAO
    @Query("SELECT * FROM clients")
    suspend fun getAllClients(): List<ClientEntity>

    @Query("SELECT * FROM clients WHERE client_id = :id")
    suspend fun getClientById(id: Int): ClientEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllClients(clients: List<ClientEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient(client: ClientEntity)

    @Delete
    suspend fun deleteClient(client: ClientEntity)

    @Query("DELETE FROM clients")
    suspend fun deleteAllClients()

//Tables DAO
    @Transaction
    @Query("SELECT * FROM tables")
    suspend fun getAllTables(): List<TableWithClient>

    @Query("SELECT * FROM tables WHERE table_id = :tableId")
    suspend fun getTableById(tableId: Int): TableWithClient

    @Query("SELECT * FROM tables WHERE client_id = :clientId")
    suspend fun getTablesByClientId(clientId: Int):  List<TableWithClient>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTables(tables: List<TableEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTable(table: TableEntity)

    @Delete
    suspend fun deleteTable(table: TableEntity)

    @Query("DELETE FROM tables")
    suspend fun deleteAllTables()

    @Transaction
    @Update
    suspend fun updateTable(table: TableEntity)
}