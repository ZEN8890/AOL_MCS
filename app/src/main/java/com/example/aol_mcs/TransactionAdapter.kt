package com.example.aol_mcs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.transaction_page_recycle_view_layout.view.*

class TransactionAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    // ViewHolder class to hold the views for each transaction item
    class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val transactionIdTextView: TextView = itemView.findViewById(R.id.transactionIdTextView)
        val dollNameTextView: TextView = itemView.findViewById(R.id.dollNameTextView)
        val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val newQuantityEditText: EditText = itemView.findViewById(R.id.newQuantityEditText)
        val updateButton: Button = itemView.findViewById(R.id.updateButton)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        // Inflate the transaction item layout
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_page_recycle_view_layout, parent, false)
        return TransactionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val currentTransaction = transactions[position]

        // Bind the data to the views
        holder.transactionIdTextView.text = currentTransaction.idt.toString()
        holder.dollNameTextView.text = currentTransaction.dollName
        holder.quantityTextView.text = currentTransaction.quantity.toString()
        holder.dateTextView.text = currentTransaction.dates

        // Set the product image
//        holder.productImageView.setImageResource(currentTransaction.imageResId)

        // Set click listeners for the update and delete buttons
        holder.updateButton.setOnClickListener {
            // Handle update button click
            // You can implement your update logic here
        }
        holder.deleteButton.setOnClickListener {
            // Handle delete button click
            // You can implement your delete logic here
        }
    }

    override fun getItemCount() = transactions.size
}

