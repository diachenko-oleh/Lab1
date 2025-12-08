package com.example.lab1.Model

data class Table(
    override val id: Int = 0,
    val capacity: Int,
    val client: Client
): IListable
