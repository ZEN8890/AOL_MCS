package com.example.aol_mcs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DollAdapter(
    private val dollList: List<Doll>,
    private val onDollClickListener: (Doll) -> Unit
) : RecyclerView.Adapter<DollAdapter.DollViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DollViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.doll_detail_page, parent, false)
        return DollViewHolder(view)
    }

    override fun onBindViewHolder(holder: DollViewHolder, position: Int) {
        val currentDoll = dollList[position]
        holder.dollName.text = currentDoll.name

        // Load doll cover image using a library like Picasso or Glide
        // Example using Glide:
        // Glide.with(holder.itemView.context).load(currentDoll.coverUrl).into(holder.dollCover)

        holder.itemView.setOnClickListener {
            onDollClickListener.invoke(currentDoll)
        }
    }

    override fun getItemCount(): Int {
        return dollList.size
    }

    class DollViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dollName: TextView = itemView.findViewById(R.id.DollNameTV)
        // Add other views for doll item (e.g., ImageView for cover)
    }
}