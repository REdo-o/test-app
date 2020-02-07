package com.example.gift_card_details

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.example.common.base.BaseViewModel
import com.example.common.utils.SharedViewModel
import com.example.model.GiftCard


class GiftCardDetailsViewModel : BaseViewModel() {

    lateinit var sharedViewModel: SharedViewModel

    var mGiftCard: MutableLiveData<GiftCard> = MutableLiveData()

    init {

        mGiftCard.value = GiftCard(
            image_url = "",
            codes_count = 0,
            credits = 0,
            description = "",
            redeem_url = "",
            sectionId = -1,

            currency = "",
            featured = false,
            id = -1,
            title = ""
        )

    }

    fun fillInfo() {

        mGiftCard.value = sharedViewModel.giftCard as GiftCard

    }

    fun onCardClick(view: View, link: String) {
        val openBrowserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(view.context, openBrowserIntent, null)
    }
}