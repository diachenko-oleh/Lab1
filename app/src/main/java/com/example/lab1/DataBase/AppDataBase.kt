package com.example.lab1.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab1.DAO.AppDAO
import com.example.lab1.Entity.ClientEntity
import com.example.lab1.Entity.TableEntity

@Database(
    entities = [ClientEntity::class, TableEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDb : RoomDatabase() {

    abstract fun appDao(): AppDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDb? = null

        fun getDatabase(context: Context): AppDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDb::class.java,
                    "database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
