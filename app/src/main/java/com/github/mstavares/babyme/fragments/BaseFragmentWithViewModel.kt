package com.github.mstavares.babyme.fragments

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithViewModel<B: ViewBinding, VM: ViewModel>(layout: Int) : BaseFragment<B>(layout) {

    protected lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = getViewModel()
    }

    abstract fun getViewModel(): VM

}
