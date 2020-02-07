package com.example.model

data class Provider(
    val gift_cards: List<GiftCard>,
    val id: Int,
    val image_url: String,
    val title: String
) {
    fun getItemsWithSectionId(): List<GiftCard> {
        gift_cards.forEach { it.sectionId = id }
        return gift_cards
    }
}