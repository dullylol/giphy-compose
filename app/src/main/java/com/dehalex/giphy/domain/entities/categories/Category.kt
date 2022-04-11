package com.dehalex.giphy.domain.entities.categories

data class Category(
    val id: String,
    val name: String,
    val subcategories: List<Subcategory>,
)