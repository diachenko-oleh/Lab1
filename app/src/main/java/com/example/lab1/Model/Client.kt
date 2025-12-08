package com.example.lab1.Model

data class Client (
    override val id: Int = 0,
    val name: String,
    val email: String
): IListable