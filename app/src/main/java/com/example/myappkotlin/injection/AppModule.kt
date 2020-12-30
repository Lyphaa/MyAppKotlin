package com.example.myappkotlin.injection

import android.content.Context
import androidx.room.Room
import com.example.myappkotlin.data.local.AppDataBase
import com.example.myappkotlin.data.local.DatabaseDao
import com.example.myappkotlin.data.repository.UserRepository
import com.example.myappkotlin.domain.usecase.CreateUserUseCase
import com.example.myappkotlin.domain.usecase.GetUserUseCase
import com.example.myappkotlin.presentation.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module{
    factory { MainViewModel(get(), get()) }

}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory {GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext())}
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase : AppDataBase = Room.databaseBuilder(
    context,
    AppDataBase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()

}
