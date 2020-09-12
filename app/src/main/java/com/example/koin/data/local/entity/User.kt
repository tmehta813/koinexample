package com.example.koin.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_Details")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String?,
    val address: String?,
    val phoneNumber: String?,
    val email: String?
)