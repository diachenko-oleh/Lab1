package com.example.lab1.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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