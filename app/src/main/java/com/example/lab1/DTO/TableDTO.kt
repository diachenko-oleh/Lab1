package com.example.lab1.DTO

import com.google.gson.annotations.SerializedName

data class TableDto(
    @SerializedName("table_id")
    val id: Int = 0,

    @SerializedName("capacity")
    val capacity: Int,

    @SerializedName("client_id")
    val clientId: Int
)
