package com.example.myappkotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.myappkotlin.R
import com.example.myappkotlin.presentation.main.LoginError
import com.example.myappkotlin.presentation.main.LoginSuccess
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mainViewModel.onStart()
        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> { MaterialAlertDialogBuilder(this).setTitle("Connection").setMessage("Vous êtes connecté").setPositiveButton("Ok"){dialog, which ->dialog.dismiss()}.show()               }
                LoginError -> { MaterialAlertDialogBuilder(this).setTitle("Erreur").setMessage("Compte inconnu").setPositiveButton("Ok"){dialog, which ->dialog.dismiss()}.show() }
            }
        })
        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())

        }


    }





}
