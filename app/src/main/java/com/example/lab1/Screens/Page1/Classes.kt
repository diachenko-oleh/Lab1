package com.example.lab1.Screens.Page1
data class Cube(
    override  val id: Int,
    val side: Double
): IListable

data class Sphere(
    override val id: Int,
    val color: String,
    val radius: Double
): IListable
