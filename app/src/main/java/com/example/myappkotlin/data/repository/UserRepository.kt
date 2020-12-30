package com.example.myappkotlin.data.repository

import com.example.myappkotlin.data.local.DatabaseDao
import com.example.myappkotlin.data.local.models.toData
import com.example.myappkotlin.data.local.models.toEntity
import com.example.myappkotlin.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {
    suspend fun createUser(user: User){
    databaseDao.insert(user.toData())

    }

    fun getUser(email: String) :  User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}
