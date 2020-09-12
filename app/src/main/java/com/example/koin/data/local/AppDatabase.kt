package com.example.koin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koin.data.local.dao.UserDao
import com.example.koin.data.local.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}