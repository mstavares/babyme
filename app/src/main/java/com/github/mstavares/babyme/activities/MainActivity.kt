package com.github.mstavares.babyme.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mstavares.babyme.R
import com.github.mstavares.babyme.utils.NavigationManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationManager.goToBabyCardScreen(supportFragmentManager)
    }
}