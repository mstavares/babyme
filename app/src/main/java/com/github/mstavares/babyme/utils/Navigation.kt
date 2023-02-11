package com.github.mstavares.babyme.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.github.mstavares.babyme.R
import com.github.mstavares.babyme.fragments.BabyCardFragment

object NavigationManager {

    private fun placeFragment(fm: FragmentManager, id: Int, fragment: Fragment) {
        val transition = fm.beginTransaction()
        transition.replace(id, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }

    fun goToBabyCardScreen(fm: FragmentManager) {
        placeFragment(fm, R.id.frame, BabyCardFragment())
    }

}