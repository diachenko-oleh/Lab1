package com.example.lab1

import android.app.Application
import com.example.lab1.DataBase.AppDb
import com.example.lab1.Repository.AppRepoImpl

class MyApp  : Application() {
    private val appDb by lazy { AppDb.getDatabase(this) }
    val appRepository by lazy { AppRepoImpl(appDb.appDao()) }
}