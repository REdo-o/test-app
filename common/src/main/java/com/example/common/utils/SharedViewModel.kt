package com.example.common.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _giftCardDetailsEvent = MediatorLiveData<Boolean>()
    val giftCardDetailsEvent: LiveData<Boolean> get() = _giftCardDetailsEvent

    lateinit var giftCard: Any

    fun updateData(giftCard: Any) {
        this.giftCard = giftCard
        _giftCardDetailsEvent.value = true
    }
}