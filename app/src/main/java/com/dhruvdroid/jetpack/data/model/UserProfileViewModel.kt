package com.dhruvdroid.jetpack.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dhruvdroid.jetpack.jetpack.User
import com.dhruvdroid.jetpack.network.UserRepository
import javax.inject.Inject

//
// Created by Dhruv Singh on 06/07/20.
//

class UserProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle,
                                               userRepository: UserRepository) : ViewModel() {
    val userId : String = savedStateHandle["uid"] ?:
    throw IllegalArgumentException("missing user id")
    val user : LiveData<User> = userRepository.getUser(userId)
}