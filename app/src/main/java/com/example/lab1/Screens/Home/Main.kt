package com.example.lab1.Screens.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab1.ViewModel.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(viewModel: MyViewModel,
         onOpenA: () -> Unit,
         onOpenB: () -> Unit) {
    val str = viewModel.homeText.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Головна сторінка") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = str,
                modifier = Modifier.Companion.fillMaxWidth()
                    .wrapContentSize(Alignment.Companion.Center)
            )
            Button(
                modifier = Modifier.Companion.padding(top = 20.dp).fillMaxWidth(),
                onClick = { viewModel.updateHomeText("це основна сторінка") }) { Text("BTN") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onOpenA
            ) { Text("Перейти на підекран A") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onOpenB
            ) { Text("Перейти на підекран B") }
        }
    }
}
