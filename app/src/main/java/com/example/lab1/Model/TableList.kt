package com.example.lab1.Model

data class TableList(
    val tableList: List<Table>, override val id: Int = 0
) : IListable
