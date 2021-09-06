package com.vtb.vtb_project.ui.sign_in

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.vtb.vtb_project.view_model.ViewModelSignIn

class GetEmail(val context: Context, val lifeCycleOwner: LifecycleOwner,val viewModelSignIn: ViewModelSignIn) : Repository {




    private val viewModelCheckEmail: ViewModelSignIn? = null
    private lateinit var email: String
    val sharedPreferences = context.getSharedPreferences("custom", Context.MODE_PRIVATE)

    override suspend fun getEmail() {

        viewModelSignIn.emailLiveData.observe(lifeCycleOwner, {
            Log.d("log","get email")
            email = it
        })
        sharedPreferences.edit().putString("Email", email)

    }

    override suspend fun checkEmail() {
        if (!sharedPreferences.getString("Email", "").isNullOrEmpty())
           viewModelCheckEmail?.checkEmailLiveData(true)

    }


}