package com.dhruvdroid.jetpack.jetpack

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

//
// Created by Dhruv on 26/06/20.
// Copyright (c) 2020 V18. All rights reserved.
//

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Query("SELECT * FROM user WHERE id = :userId")
    fun load(userId: String): LiveData<User>
}