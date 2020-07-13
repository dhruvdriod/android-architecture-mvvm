package com.dhruvdroid.jetpack.userProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.dhruv_droid.jetpack.R
import kotlinx.android.synthetic.main.fragment_user_profile.*

//
// Created by Dhruv  on 06/07/20.
//

class UserProfileFragment : Fragment() {
    private val viewModel: UserProfileViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {user ->
            // Every time the user profile data is updated, the onChanged()
            userName.text = user.name
            mobile.text = user.mobile
        }
    }
}