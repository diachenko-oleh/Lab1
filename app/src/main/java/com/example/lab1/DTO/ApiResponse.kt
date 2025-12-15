package com.example.lab1.DTO

data class ApiResponse(
    val clients: List<ClientDto>,
    val tables: List<TableDto>
)
