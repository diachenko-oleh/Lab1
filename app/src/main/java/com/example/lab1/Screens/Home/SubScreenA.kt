package com.example.lab1.Screens.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SubScreenA( onBack: () -> Unit,onNavigateToB: () -> Unit) {
    Column(
        modifier = Modifier.Companion
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        MyTopAppBar(onBack = onBack)
        Text("Підекран A")
        Button(
            onClick = onNavigateToB,
            modifier = Modifier.Companion.padding(top = 20.dp)
        ) {
            Text("Перейти на B")
        }
    }
}