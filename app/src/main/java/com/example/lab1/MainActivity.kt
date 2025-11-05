package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab1.ui.theme.Lab1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Lab1App()
            }
        }
    }
}

class MyViewModel : ViewModel() {
    val homePageText = mutableStateOf("MAIN PAGE")
    val homeText = homePageText
    fun updateHomeText(newText: String) {
        homePageText.value = newText
    }

}
@PreviewScreenSizes
@Composable
fun Lab1App() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ){
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            when (currentDestination) {
                AppDestinations.HOME -> HomeScreen(modifier = Modifier.padding(innerPadding))
                AppDestinations.PAGE1 -> Page1(modifier = Modifier.padding(innerPadding))
                AppDestinations.PAGE2 -> Page2(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("HOME", Icons.Default.Home),
    PAGE1("PAGE 1", Icons.Default.Info),
    PAGE2("PAGE 2", Icons.Default.Info),
}


@Composable
fun HomeScreen(modifier: Modifier) {
    val viewModel: MyViewModel = viewModel()
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ){
        val str = viewModel.homeText.value
        Text(
            text = str,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )
        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
            onClick = {viewModel.updateHomeText("це основна сторінка")}) { Text("BTN")}
    }
}

@Composable
fun Page1(modifier: Modifier) {
    Column(
        modifier =  modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        var str by rememberSaveable {  mutableStateOf("PAGE 1")}
        Text(
            text = str,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )
        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
            onClick = {str = "це перша сторінка"}) { Text("BTN")}
    }
}


@Composable
fun Page2(modifier: Modifier) {
    Column(
        modifier =  modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        var str by remember {  mutableStateOf("PAGE 2")}
        Text(
            text = str,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )
        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
            onClick = {str = "це друга сторінка"}) { Text("BTN")}
    }
}



