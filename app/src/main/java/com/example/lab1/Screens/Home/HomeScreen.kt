package com.example.lab1.Screens.Home


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab1.ViewModel.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier) {
    val navController = rememberNavController()
    val viewModel: MyViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = HomeSubScreen.Main.route,
    ) {
        composable(HomeSubScreen.Main.route) {
            Main(
                viewModel,
                {navController.navigate(HomeSubScreen.SubA.route) },
                {navController.navigate(HomeSubScreen.SubA.route) }
            )
        }

        composable(HomeSubScreen.SubA.route) {
            SubScreenA(
                onBack = { navController.navigateUp() },
                onNavigateToB = { navController.navigate(HomeSubScreen.SubB.route)}
            )
        }

        composable(HomeSubScreen.SubB.route) {
            SubScreenB(
                onBack = { navController.navigateUp() }
            )
        }
    }
}
