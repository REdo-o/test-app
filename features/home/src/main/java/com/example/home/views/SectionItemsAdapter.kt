package com.example.home.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.home.HomeViewModel
import com.example.home.R
import com.example.model.Provider

class SectionItemsAdapter(private val viewModel: HomeViewModel): RecyclerView.Adapter<SectionItemsViewHolder>() {

    private val listItems : MutableList<Provider> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = SectionItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_section, parent, false))

    override fun getItemCount(): Int
            = listItems.size

    override fun onBindViewHolder(holder: SectionItemsViewHolder, position: Int)
            = holder.bindTo(listItems[position], viewModel)

    // ---

    fun updateData(items: List<Provider>) {
        val diffCallback = SectionItemsDiffCallback(listItems, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listItems.clear()
        listItems.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
}