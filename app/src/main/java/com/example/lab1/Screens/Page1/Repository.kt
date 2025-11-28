package com.example.lab1.Screens.Page1
class DataRepository {

    fun getAllData(): List<IListable> {

        val megaList = listOf(
            Cube(1,15.0),
            Cube(2,8.0),
            Cube(3,10.0),
            Sphere(1, "red", 15.0 ),
            Sphere(2, "green", 8.0),
            Sphere(3, "blue", 10.0)
        )
        return megaList
    }

}