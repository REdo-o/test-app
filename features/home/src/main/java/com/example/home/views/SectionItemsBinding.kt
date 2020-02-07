package com.example.home.views

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Provider

object SectionItemsBinding {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, photoItems: List<Provider>?) {
        with(recyclerView.adapter as SectionItemsAdapter) {
            photoItems?.let { updateData(it) }
        }
    }

}