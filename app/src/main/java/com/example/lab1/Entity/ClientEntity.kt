package com.example.lab1.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "clients"
)
data class ClientEntity(
    @PrimaryKey(
        autoGenerate = true
    )
    @ColumnInfo(name = "client_id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "email")
    val email: String
)