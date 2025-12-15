package com.example.lab1.API

import com.example.lab1.DTO.ApiResponse
import retrofit2.http.GET

interface MyApi {

    @GET("diachenko-oleh/lab1-api/refs/heads/main/data.json")
    suspend fun getAllData(): ApiResponse
}