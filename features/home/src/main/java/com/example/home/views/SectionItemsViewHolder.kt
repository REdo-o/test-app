package com.example.home.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.home.HomeViewModel
import com.example.home.databinding.ItemSectionBinding
import com.example.model.Provider

class SectionItemsViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    private val binding = ItemSectionBinding.bind(parent)

    fun bindTo(provider: Provider, viewModel: HomeViewModel) {
        binding.sectionItem = provider
        binding.viewmodel = viewModel
        binding.adapter = NestedItemsAdapter(viewModel)

    }
}