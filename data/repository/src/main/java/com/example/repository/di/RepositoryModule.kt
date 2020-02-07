package com.example.repository.di

import com.example.repository.AppDispatchers
import com.example.repository.ProviderRepository
import com.example.repository.ProviderRepository.ProviderRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { ProviderRepositoryImpl(get()) as ProviderRepository }
}