package com.example.home.views

import androidx.recyclerview.widget.DiffUtil
import com.example.model.Provider

class SectionItemsDiffCallback(
    private val oldList: List<Provider>,
    private val newList: List<Provider>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }
}