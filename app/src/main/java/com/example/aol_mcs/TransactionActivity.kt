package com.example.aol_mcs

import android.content.Intent
import android.view.MenuItem
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aol_mcs.R
import com.example.aol_mcs.Transaction
import kotlinx.android.synthetic.main.transaction_page_recycle_view.*

class TransactionActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var transactionAdapter: TransactionAdapter
    private val transactions = mutableListOf<Transaction>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transaction_page_recycle_view)

        // Initialize recyclerView by finding it in the layout
        recyclerView = findViewById(R.id.recycler_view)

        transactionAdapter = TransactionAdapter(transactions)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = transactionAdapter

        // Fetch transaction data from the database
        fetchTransactions()


        // Enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Dummy function to fetch transactions from the database
    private fun fetchTransactions() {
        // For demonstration purposes, returning dummy data
        transactions.addAll(
            listOf(
                Transaction(1, "Doll 1", 5, "2024-03-01"),
                Transaction(2, "Doll 2", 3, "2024-03-02"),
                Transaction(3, "Doll 3", 2, "2024-03-03")
            )
        )
        transactionAdapter.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish() // Finish the current activity
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}








