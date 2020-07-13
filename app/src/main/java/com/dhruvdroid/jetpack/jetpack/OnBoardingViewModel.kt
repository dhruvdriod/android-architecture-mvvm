package com.dhruvdroid.jetpack.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dhruvdroid.jetpack.userProfile.User
import com.dhruvdroid.jetpack.userProfile.UserRepository
import javax.inject.Inject

//
// Created by Dhruv Singh on 26/06/20
//

class OnBoardingViewModel @Inject constructor(savedStateHandle: SavedStateHandle, userRepository: UserRepository) : ViewModel() {

    val userId: String = savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")
    val user: LiveData<User> = userRepository.getUser(userId)
}