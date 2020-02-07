package com.example.home.di

import com.example.home.HomeViewModel
import com.example.home.domain.ProvidersListUseCase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val featureHomeModule = module {
    factory { ProvidersListUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}