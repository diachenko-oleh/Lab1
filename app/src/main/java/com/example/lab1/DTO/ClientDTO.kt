package com.example.lab1.DTO

import com.google.gson.annotations.SerializedName

data class ClientDto(
    @SerializedName("client_id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String
)
