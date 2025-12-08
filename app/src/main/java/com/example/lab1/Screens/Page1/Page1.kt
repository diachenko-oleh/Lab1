package com.example.lab1.Screens.Page1


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab1.Entity.TableWithClient
import com.example.lab1.Model.Client
import com.example.lab1.Model.ClientList
import com.example.lab1.Model.IListable
import com.example.lab1.Model.Table
import com.example.lab1.Model.TableList
import com.example.lab1.ViewModel.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page1(modifier: Modifier) {
    val viewModel: MyViewModel = viewModel()
    val megaList by viewModel.megaList.collectAsState(emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Сторінка зі cписком") }
            )
        }
    ) { padding ->

        Column(modifier = modifier) {
            LaunchedEffect(Unit) {
                viewModel.getAllData()
            }

            LazyColumn(
                modifier = modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .weight(1.0f)

            ) {
                items(megaList) { item ->
                    when (item) {
                        is Client -> ClientCard(item, { viewModel.deleteClientFromDb(item) })
                        is Table -> TableCard(item,viewModel)
                        is ClientList -> ClientListCard(item)
                        is TableList -> { /* TODO */ }
                    }
                }
            }

            Button(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                onClick = {
                    viewModel.loadAllDataToDb()
                }
            )
            { Text("Load Data to Data Base") }

            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                onClick = {
                    viewModel.clearAllDataFromDb()
                })
            { Text("Clear Data Base") }
        }

    }

}

@Composable
fun ClientCard(client: Client, onDelClient: () -> Unit){
    Card(
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Text("Клієнт: ", Modifier.padding(10.dp), fontSize = 20.sp)
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text("client name: ${client.name}")
            Text("client email: ${client.email}")
        }
        Button(
            onClick = onDelClient
        )
        { Text("delete") }
    }
}

@Composable
fun ClientCardInList(client: Client){
    Card(
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Text("Клієнт: ", Modifier.padding(10.dp), fontSize = 20.sp)
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text("client name: ${client.name}")
            Text("client email: ${client.email}")
        }
    }
}

@Composable
fun TableCard(table: Table, viewModel: MyViewModel){
    Card(
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Text("Стіл: ", Modifier.padding(10.dp), fontSize = 20.sp)
        Column(
            modifier = Modifier.padding(5.dp)
        ){
            Text("table capacity: ${table.capacity}")
            Text("client: ${table.client}")
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    viewModel.changeTableCapacity(table, 1)
                })
            { Text("+1") }

            Button(
                onClick = {
                    viewModel.changeTableCapacity(table, -1)
                })
            { Text("-1") }
            Button(
                onClick = {
                    viewModel.deleteTableFromDb(table)
                })
            { Text("delete") }
        }
    }
}

@Composable
fun ClientListCard(clientList: ClientList) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(clientList.clientList) { item ->
            ClientCardInList(item)
        }
    }
}

@Composable
fun TableListCard(tableList: TableList, viewModel: MyViewModel) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(tableList.tableList) { item ->
            TableCard(item, viewModel)
        }
    }
}