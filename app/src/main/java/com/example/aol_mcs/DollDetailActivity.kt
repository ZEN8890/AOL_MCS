package com.example.aol_mcs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.doll_detail_page.*

    class DollDetailActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.doll_detail_page)

            // Retrieve doll data from intent
            val doll = intent.getParcelableExtra<Doll>("doll")

            // Display doll details
            doll?.let {
                textViewDollName.text = it.name
                textViewDollSize.text = "Size: ${it.size}"
                textViewDollRating.text = "Rating: ${it.rating}"
                textViewDollPrice.text = "Price: $${it.price}"
                textViewDollDescription.text = it.description

                // Load image using Glide
                Glide.with(this)
                    .load(it.imageUrl)
                    .into(imageViewDollCover)

                buttonback.setOnClickListener {
                    onBackPressed()
                }

            }
        }
    }


