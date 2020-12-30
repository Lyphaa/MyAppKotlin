package com.example.myappkotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myappkotlin.data.local.models.UserLocal

@Database(entities = arrayOf(UserLocal::class), version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun databaseDao(): DatabaseDao
}