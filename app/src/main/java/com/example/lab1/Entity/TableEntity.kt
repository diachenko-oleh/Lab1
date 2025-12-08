package com.example.lab1.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "tables",
    foreignKeys = [
        ForeignKey(
            entity = ClientEntity::class,
            parentColumns = arrayOf("client_id"),
            childColumns = arrayOf("client_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TableEntity (
    @PrimaryKey(
        autoGenerate = true
    )
    @ColumnInfo(name = "table_id")
    val id: Int = 0,

    @ColumnInfo(name = "capacity")
    val capacity: Int,

    @ColumnInfo(name = "client_id", index = true)
    val clientId: Int

    )