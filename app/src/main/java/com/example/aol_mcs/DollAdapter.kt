package com.example.aol_mcs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aol_mcs.Doll


class DollAdapter(private val context: Context, private val dollList: List<Doll>) :
    RecyclerView.Adapter<DollAdapter.DollViewHolder>() {

    private var onItemClickListener: ((Int) -> Unit)? = null

    inner class DollViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coverImageView: ImageView = itemView.findViewById(R.id.image_view_cover)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(adapterPosition)
            }
        }

        fun bind(doll: Doll) {
            Glide.with(context).load(doll.coverUrl).into(coverImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DollViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doll, parent, false)
        return DollViewHolder(view)
    }

    override fun onBindViewHolder(holder: DollViewHolder, position: Int) {
        holder.bind(dollList[position])
    }

    override fun getItemCount(): Int {
        return dollList.size
    }

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    fun getItem(position: Int): Doll {
        return dollList[position]
    }
}

