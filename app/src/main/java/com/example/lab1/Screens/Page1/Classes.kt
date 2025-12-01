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

data class CubeList(
    val cubeList: List<Cube>,
    override val id: Int = 0
) : IListable

data class SphereList(
    val sphereList: List<Sphere>,
    override val id: Int = 0
) : IListable