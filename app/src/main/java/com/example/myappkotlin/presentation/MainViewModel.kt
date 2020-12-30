package com.example.myappkotlin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappkotlin.domain.entity.User
import com.example.myappkotlin.domain.usecase.CreateUserUseCase
import com.example.myappkotlin.domain.usecase.GetUserUseCase
import com.example.myappkotlin.presentation.main.LoginError
import com.example.myappkotlin.presentation.main.LoginStatus
import com.example.myappkotlin.presentation.main.LoginSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
           val user = getUserUseCase.invoke(emailUser)

            val loginStatus = if(user != null){
                LoginSuccess(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus }



        }
       //counter.value = (counter.value ?: 0) +1
    }


}