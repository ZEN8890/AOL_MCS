package com.example.aol_mcs

data class Transaction(
    val idt: String,
    val dollName: String,
    var quantity: Int,
    val dates: String
)