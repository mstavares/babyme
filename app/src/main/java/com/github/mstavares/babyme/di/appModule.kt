package com.github.mstavares.babyme.di

import com.github.mstavares.babyme.data.BabyRepositoryImpl
import com.github.mstavares.babyme.data.TxtBabyDataSource
import com.github.mstavares.babyme.domain.repositories.BabyRepository
import com.github.mstavares.babyme.domain.usecases.GetBaby
import com.github.mstavares.babyme.viewmodels.BabyCardViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { BabyCardViewModel(androidApplication(), get()) }
    single { TxtBabyDataSource(androidContext(), "dataset.txt")}
    single<BabyRepository> { BabyRepositoryImpl(get<TxtBabyDataSource>()) }
    single { GetBaby(get()) }

}