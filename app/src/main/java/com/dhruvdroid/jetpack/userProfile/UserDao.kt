package com.dhruvdroid.jetpack.userProfile

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
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

    @Query("SELECT * FROM user WHERE uId = :userId")
    fun load(userId: String): LiveData<User>

    @Query("SELECT * FROM user WHERE uId = :userId")
    fun hasUser(userId: String): Boolean

    @Delete
    fun delete(user: User)

    @Insert
    fun insertAll(vararg users: User)

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

}