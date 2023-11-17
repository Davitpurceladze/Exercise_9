package com.example.exercise_9

object Data {
    data class Item(
        val image: Int,
        val title: String,
        val price: String,
        val categoryType: String,
        val id: Int
    )

    private val items: MutableList<Item> = mutableListOf()

    private val photos: List<Int> = listOf(
        R.drawable.item_photo_black,
        R.drawable.item_photo_green,
        R.drawable.item_photo_red,
        R.drawable.item_photo_yellow,
        )

    private val titles: List<String> = listOf(
        "Leather Jacket",
        "Puffer Jacket",
        "Raincoat",
        "Jean Jacket"
    )

    private val prices: List<String> = listOf(
        "$120",
        "$180",
        "$50",
        "$260",
    )

    private val categoryTypes: List<String> = listOf(
        "category_party",
        "category_beach",
        "category_school",
        "category_club",
        "category_denim",
        "category_hiking"
    )

    fun getItems(): MutableList<Item> {
         for(number in 1..50) {
             val randomInFourNumber: Int = (0..3).shuffled().first()
             val randomInSixNumber: Int = (0..5).shuffled().first()
             items.add(Item(photos[randomInFourNumber], titles[randomInFourNumber], prices[randomInFourNumber],
                 categoryTypes[randomInSixNumber], number))
         }

        return items
    }


}