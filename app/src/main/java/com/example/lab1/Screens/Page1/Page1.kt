package com.example.lab1.Screens.Page1


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
        LaunchedEffect(Unit) {
            viewModel.getAllData()
        }
        LazyColumn(
            modifier = modifier.padding(padding).fillMaxWidth()
        ) {
            items(megaList) { item ->
                when (item) {
                    is Cube -> CubeCard(item)
                    is Sphere -> SphereCard(item)
                    is CubeList -> CubeListCard(item)
                    is SphereList -> SphereListCard(item)
                }
            }
        }


    }
}

@Composable
fun CubeCard(cube: Cube){
    Card(
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Text("Куб: ", Modifier.padding(10.dp), fontSize = 20.sp)
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text("Сторона: ${cube.side}")
            Text("Сторона: ${cube.side}")
            Text("Сторона: ${cube.side}")
        }
    }
}

@Composable
fun SphereCard(sph: Sphere){
    Card(
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Text("Сфера: ", Modifier.padding(10.dp), fontSize = 20.sp)
        Column(
            modifier = Modifier.padding(5.dp)
        ){
            Text("Сторона: ${sph.radius}")
            Text("Сторона: ${sph.radius}")
            Text("Сторона: ${sph.radius}")
        }

    }
}

@Composable
fun CubeListCard(cubeList: CubeList) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(cubeList.cubeList) { item ->
            CubeCard(item)
        }
    }
}

@Composable
fun SphereListCard(sphereList: SphereList) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(sphereList.sphereList) { item ->
            SphereCard(item)
        }
    }
}