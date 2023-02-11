package com.github.mstavares.babyme

import android.app.Application
import com.github.mstavares.babyme.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BabyMeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BabyMeApplication)
            modules(listOf(appModule))
        }
    }

}