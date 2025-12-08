package com.example.lab1.Model

data class ClientList(
    val clientList: List<Client>, override val id: Int = 0
) : IListable