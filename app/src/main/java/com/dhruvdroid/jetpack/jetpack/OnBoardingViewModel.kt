package com.dhruvdroid.jetpack.jetpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

//
// Created by Dhruv Singh on 26/06/20
//

class OnBoardingViewModel @Inject constructor(savedStateHandle: SavedStateHandle, userRepository: UserRepository) : ViewModel() {

    val userId: String = savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")
    val user: LiveData<User> = userRepository.getUser(userId)
}

//private val viewModel : OnBoardingViewModel by viewModel(factoryProducer = {SavedStateVMFactory(this)})

// UserProfileFragment
//private val viewModel: OnBoardingViewModel by viewModels(factoryProducer = { SavedStateVMFactory(this)
//})