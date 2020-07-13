package com.dhruvdroid.jetpack.userProfile

import androidx.room.Database
import androidx.room.RoomDatabase

//
// Created by Dhruv Singh on 26/06/20.
//

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}