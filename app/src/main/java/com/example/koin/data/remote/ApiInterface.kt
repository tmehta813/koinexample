package com.example.koin.data.remote

import kotlinx.coroutines.Deferred
import com.example.koin.data.local.entity.User
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getUserDetails(): Deferred<List<User>>
}