package com.example.lab1.Utils

import com.example.lab1.DTO.ClientDto
import com.example.lab1.DTO.TableDto
import com.example.lab1.Entity.ClientEntity
import com.example.lab1.Entity.TableEntity
import com.example.lab1.Entity.TableWithClient
import com.example.lab1.Model.Client
import com.example.lab1.Model.Table

fun Client.toEntity() = ClientEntity(
    id = this.id,
    name = this.name,
    email = this.email
)

fun ClientEntity.toDomain() = Client(
    id = this.id,
    name = this.name,
    email = this.email
)

fun Table.toEntity() = TableEntity(
    id = this.id,
    capacity = this.capacity,
    clientId = this.client.id,
)

fun TableWithClient.toDomain() = Table(
    id = this.table.id,
    capacity = this.table.capacity,
    client = this.client.toDomain()
)


fun ClientDto.toEntity() = ClientEntity(
    id = id,
    name = name,
    email = email
)

fun ClientDto.toDomain() = Client(
    id = id,
    name = name,
    email = email
)

fun TableDto.toEntity() = TableEntity(
    id = id,
    capacity = capacity,
    clientId = clientId
)

fun TableDto.toDomain() = Table(
    id = id,
    capacity = capacity,
    client = TODO()
)

