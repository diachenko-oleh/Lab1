package com.example.lab1.Screens.Home

sealed class HomeSubScreen(val route: String) {
    object SubA : HomeSubScreen("subA")
    object SubB : HomeSubScreen("subB")
}