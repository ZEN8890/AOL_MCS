package com.example.aol_mcs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DollAdapter(
    private val context: Context,
    private val dollList: List<Doll>,
    private val onItemClick: (Doll) -> Unit,
    private val onBuyClick: (Doll) -> Unit
) : RecyclerView.Adapter<DollAdapter.DollViewHolder>() {

    inner class DollViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view_cover)
        val nameTextView: TextView = itemView.findViewById(R.id.textViewDollName)
        private val buyButton: Button = itemView.findViewById(R.id.buttonBuy)

        init {
            // Set click listener for the item view
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val doll = dollList[position]
                    onItemClick(doll)
                }
            }

            // Set click listener for buy button
            buyButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val doll = dollList[position]
                    onBuyClick(doll)
                    val transaction = Transaction(doll.ids, doll.name, 1, "2024-03-06")
                    TransactionList.transactions.add(transaction) // Add the transaction to the list
                    showToast("Item added to transaction page")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DollViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_page_recycler_layout, parent, false)
        return DollViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DollViewHolder, position: Int) {
        val currentDoll = dollList[position]

        Glide.with(context)
            .load(currentDoll.imageUrl)
            .into(holder.imageView)

        holder.nameTextView.text = currentDoll.name
    }

    override fun getItemCount(): Int {
        return dollList.size
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}












