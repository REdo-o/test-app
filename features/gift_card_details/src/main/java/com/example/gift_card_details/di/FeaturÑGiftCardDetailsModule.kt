package com.example.gift_card_details.di

import com.example.gift_card_details.GiftCardDetailsViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val featureGiftCardDetailsModule = module {
    viewModel { GiftCardDetailsViewModel() }
}