package com.example.lab1.Screens.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubScreenA(onBack: () -> Unit, onNavigateToB: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Підекран A") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            Text("Підекран A")
            Button(
                onClick = onNavigateToB,
                modifier = Modifier.Companion.padding(top = 20.dp)
            ) { Text("Перейти на B") }
            Button(
                onClick = onBack,
                modifier = Modifier.Companion.padding(top = 20.dp)
            ) { Text("Назад") }
        }
    }

}