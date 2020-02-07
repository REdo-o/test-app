package com.example.test_app.di

import com.example.gift_card_details.di.featureGiftCardDetailsModule
import com.example.home.di.featureHomeModule
import com.example.remote.di.createRemoteModule
import com.example.repository.di.repositoryModule

val appComponent = listOf(
    createRemoteModule("https://imya.bslab.ru/"),
    repositoryModule,
    featureHomeModule,
    featureGiftCardDetailsModule
)