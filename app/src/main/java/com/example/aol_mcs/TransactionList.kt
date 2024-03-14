package com.example.aol_mcs

object TransactionList {
    val transactions = mutableListOf<Transaction>()

    fun addTransaction(idt: String,dollName : String, quantity: Int,dates:String) {
        val transaction = Transaction(idt,dollName, quantity , dates)
        transactions.add(transaction)
    }
}


