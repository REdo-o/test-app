package com.example.home.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.home.R
import com.example.model.GiftCard
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object NestedItemsBinding {

    @BindingAdapter("app:nestedItems")
    @JvmStatic
    fun setNestedItems(recyclerView: RecyclerView, photoItems: List<GiftCard>?) {
        with(recyclerView.adapter as NestedItemsAdapter) {
            photoItems?.let { updateData(it) }
        }
    }

    @BindingAdapter("app:imagePath")
    @JvmStatic
    fun loadImageUrl(view: ImageView, url: Any) {
        Glide.with(view.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(view)
    }

    @BindingAdapter("app:backgroundColor")
    @JvmStatic
    fun setBackgroundColor(view: View, sectionId: Int) {
        view.setBackgroundColor(
            view.context.getColor(
                when (sectionId) {
                    1 -> R.color.orange_peel
                    2 -> R.color.outer_space
                    else -> R.color.orange_peel
                }
            )
        )
    }

    @BindingAdapter("app:currencySign")
    @JvmStatic
    fun setCurrencySign(textView: TextView, currency: String) {
        textView.text = when (currency) {
            "USD" -> "$"
            "EUR" -> "€"
            else -> "$"
        }
    }
}