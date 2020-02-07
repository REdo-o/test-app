package com.example.model

data class GiftCard(
    val codes_count: Int,
    val credits: Int,
    val currency: String,
    val description: String,
    val featured: Boolean,
    val id: Int,
    val image_url: String,
    val redeem_url: String,
    val title: String,
    var sectionId: Int
)