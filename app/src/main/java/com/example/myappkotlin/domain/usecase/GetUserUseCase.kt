package com.example.myappkotlin.domain.usecase

import com.example.myappkotlin.data.repository.UserRepository
import com.example.myappkotlin.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String): User? {
        return userRepository.getUser(email)

    }

}