package com.example.lab1.Screens.Page1


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab1.ViewModel.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page1(modifier: Modifier) {
    val viewModel: MyViewModel = viewModel()
    val users by viewModel.users.collectAsState()
    val spheres by viewModel.spheres.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Сторінка зі cписком") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = modifier.padding(padding).fillMaxWidth()
        ) {
            item {
                Text("Користувачі:", fontSize = 24.sp)
            }
            item{
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ){
                    items(users) { user ->
                        Text("Ім'я: ${user.name}, вік: ${user.age}")
                        Spacer(modifier = Modifier.width(15.dp))
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text("Сфери:", fontSize = 24.sp)
            }
            items(spheres) { sphere ->
                Text("Колір: ${sphere.color}, радіус: ${sphere.radius}")
            }
        }


    }
}
