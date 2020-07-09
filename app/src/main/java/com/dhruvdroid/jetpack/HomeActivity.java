package com.dhruvdroid.jetpack;
//
// Created by  on 09/07/20.
//

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dhruv_droid.jetpack.R;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
