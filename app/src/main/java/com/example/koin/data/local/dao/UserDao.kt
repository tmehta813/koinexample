package com.example.koin.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.koin.data.local.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User_Details")
    fun findAllUsers(): LiveData<List<User>>

    @Insert
    fun insert(users: List<User>)

    @Insert
    fun insert(users: User)

    @Delete
    fun delete(users: User)
}