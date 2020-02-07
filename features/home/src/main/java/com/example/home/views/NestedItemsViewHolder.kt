package com.example.home.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.home.HomeViewModel
import com.example.home.databinding.ItemGiftCardBinding
import com.example.model.GiftCard

class NestedItemsViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = ItemGiftCardBinding.bind(parent)

    fun bindTo(giftCard: GiftCard, viewModel: HomeViewModel) {
        binding.cardItem = giftCard
        binding.viewmodel = viewModel

    }
}