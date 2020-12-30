package com.example.myappkotlin.domain.usecase

import com.example.myappkotlin.data.repository.UserRepository
import com.example.myappkotlin.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)

    }

}