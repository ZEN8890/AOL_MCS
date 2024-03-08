package com.example.aol_mcs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.doll_detail_page.*

class DollDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doll_detail_page)

        // Retrieve doll data from intent
        val doll = intent.getParcelableExtra<Doll>("doll")

        // Display doll details
        doll?.let {
            imageViewDollCover.setImageResource(it.coverUrl)
            textViewDollName.text = it.name
            textViewDollSize.text = "Size: ${it.size}"
            textViewDollRating.text = "Rating: ${it.rating}"
            textViewDollPrice.text = "Price: $${it.price}"
            textViewDollDescription.text = it.description

            // Buy button click listener
            buttonBuy.setOnClickListener {
                val quantity = editTextQuantity.text.toString().toIntOrNull()

                if (quantity != null && quantity > 0) {
                    // Insert transaction into the database
                    insertTransaction(doll, quantity)
                    // Show success message
                    Toast.makeText(this, "Transaction successful", Toast.LENGTH_SHORT).show()
                } else {
                    // Show error message for invalid quantity
                    Toast.makeText(this, "Invalid quantity", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun insertTransaction(doll: Doll, quantity: Int) {
        // Implement database insertion logic here
        // You can use Room, SQLite, or any other database technology
        // Here, we'll just print the transaction details
        println("Transaction Details:")
        println("com.example.aol_mcs.com.example.aol_mcs.Doll Name: ${doll.name}")
        println("Quantity: $quantity")
    }
}
