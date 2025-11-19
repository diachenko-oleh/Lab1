package com.example.lab1.Screens.Home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

sealed class HomeSubScreen(val route: String) {
    object SubA : HomeSubScreen("subA")
    object SubB : HomeSubScreen("subB")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onBack: () -> Unit) {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
            }
        }
    )
}