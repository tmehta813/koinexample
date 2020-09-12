package com.example.koin.domain.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.koin.data.remote.ApiInterface
import com.example.koin.data.local.dao.UserDao
import com.example.koin.data.local.entity.User
import kotlinx.coroutines.delay

class UserRepository(private val api: ApiInterface, private val dao: UserDao) {

    val usersData = dao.findAllUsers()

    suspend fun getUserDetails() {
        withContext(Dispatchers.IO) {

            //todo call your api here
//            val users = api.getUserDetails().await()
//            dao.insert(users)

             //used for testing purpose
              insertData()
        }
    }

    private suspend fun insertData(){
        delay(2000)
        val data= User(
            name = "Tarun",
            address = "India",
            email = "testing@gmail.com",
            phoneNumber = "1234567890"
        )
        dao.insert(data)
    }
}