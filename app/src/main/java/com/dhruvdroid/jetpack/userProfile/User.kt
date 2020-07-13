package com.dhruvdroid.jetpack.userProfile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//
// Created by Dhruv Singh on 26/06/20.
//

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val uId: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "mobile")
    val mobile: String)