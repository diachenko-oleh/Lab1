package com.example.lab1.Entity

import androidx.room.Embedded
import androidx.room.Relation

data class TableWithClient (
    @Embedded val table: TableEntity,
    @Relation(
        parentColumn = "client_id",
        entityColumn = "client_id"
    )
    val client: ClientEntity
)