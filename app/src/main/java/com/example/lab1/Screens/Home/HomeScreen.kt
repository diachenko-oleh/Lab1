package com.example.lab1.Screens.Home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab1.ViewModel.MyViewModel

@Composable
fun HomeScreen(modifier: Modifier) {
    val navController = rememberNavController()
    val viewModel: MyViewModel = viewModel()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        val str = viewModel.homeText.value
        Text(
            text = str,
            modifier = Modifier.Companion.fillMaxWidth()
                .wrapContentSize(Alignment.Companion.Center)
        )
        Button(
            modifier = Modifier.Companion.padding(top = 20.dp).fillMaxWidth(),
            onClick = { viewModel.updateHomeText("це основна сторінка") }) { Text("BTN") }

        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
            onClick = { navController.navigate(HomeSubScreen.SubA.route) }
        ) {
            Text("Перейти на підекран A")
        }

        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
            onClick = { navController.navigate(HomeSubScreen.SubB.route) }
        ) {
            Text("Перейти на підекран B")
        }

        NavHost(
            navController = navController,
            startDestination = "home_root"
        ) {
            composable("home_root") {
            }
            composable(HomeSubScreen.SubA.route) {
                SubScreenA(
                    onNavigateToB = {
                        navController.navigate(HomeSubScreen.SubB.route)
                    },
                    onBack = { navController.navigateUp() }
                )
            }

            composable(HomeSubScreen.SubB.route) {
                SubScreenB(
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}