package com.example.home.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home.HomeViewModel
import com.example.home.R
import com.example.model.GiftCard

class NestedItemsAdapter(private val viewModel: HomeViewModel): RecyclerView.Adapter<NestedItemsViewHolder>() {

    private val nestedListItems : MutableList<GiftCard> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = NestedItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_gift_card, parent, false))

    override fun getItemCount(): Int
            = nestedListItems.size

    override fun onBindViewHolder(holder: NestedItemsViewHolder, position: Int)
            = holder.bindTo(nestedListItems[position], viewModel)

    // ---

    fun updateData(items: List<GiftCard>) {
        val diffCallback = NestedItemsDiffCallback(nestedListItems, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        nestedListItems.clear()
        nestedListItems.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
}