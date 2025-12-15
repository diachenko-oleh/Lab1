package com.example.lab1.Model

data class Table(
    override val id: Int = 0,
    var capacity: Int,
    val client: Client
): IListable
