package com.example.aol_mcs

data class Transaction(
    val id: Int,
    val dollName: String,
    var quantity: Int,
    val date: String,
//    val imageResId: Int
)