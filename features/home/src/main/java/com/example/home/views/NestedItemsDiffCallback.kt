package com.example.home.views

import androidx.recyclerview.widget.DiffUtil
import com.example.model.GiftCard

class NestedItemsDiffCallback(private val oldList: List<GiftCard>,
                              private val newList: List<GiftCard>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}