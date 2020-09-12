package com.example.koin.presentation.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.koin.R
import com.example.koin.presentation.MyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.koin.utils.LoadingState


class MainActivity : FragmentActivity() {

    private val userViewModel by viewModel<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel.getUserDetails()

        userViewModel.data.observe(this, Observer {
            it.forEach { users ->
                //todo You can populate your data here
                Log.e("users",users.toString())
            }
        })

        userViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
                LoadingState.Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
