package com.dhruvdroid.jetpack.userProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

//
// Created by Dhruv Singh on 06/07/20.
//

class UserProfileViewModel @Inject constructor(savedStateHandle: SavedStateHandle,
                                               userRepository: UserRepository
) : ViewModel() {
    val userId : String = savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")
    val user : LiveData<User> = userRepository.getUser(userId)

}