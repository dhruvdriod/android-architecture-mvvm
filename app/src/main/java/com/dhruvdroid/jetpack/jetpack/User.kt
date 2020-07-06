package com.dhruvdroid.jetpack.jetpack

import androidx.room.Entity
import androidx.room.PrimaryKey

//
// Created by Dhruv Singh on 26/06/20.
//

@Entity
data class User(
        @PrimaryKey private val id: String,
        private val name: String,
        private val lastName: String
)