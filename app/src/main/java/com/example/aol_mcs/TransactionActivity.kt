package com.example.aol_mcs

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aol_mcs.R

class TransactionActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transaction_page_recycle_view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recycler_view)

        // Initialize the transaction adapter with TransactionList.transactions
        transactionAdapter = TransactionAdapter(TransactionList.transactions)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = transactionAdapter

        // Retrieve doll data from intent and add it to the transaction list
        val doll: Doll? = intent.getParcelableExtra("doll")
        doll?.let {
            val transaction = Transaction(it.ids, it.name, 1, "2024-03-06") // You may adjust other parameters as needed
            TransactionList.transactions.add(transaction)
            transactionAdapter.notifyDataSetChanged()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Navigate to the home page and clear the back stack
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


















