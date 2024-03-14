package com.example.aol_mcs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aol_mcs.R
import kotlinx.android.synthetic.main.home_page.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dollAdapter: DollAdapter
    private val dollList = mutableListOf<Doll>()

    // Declare a variable to keep track of the selected menu item
    private var selectedMenuItemId: Int = R.id.menu_home

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    if (selectedMenuItemId != R.id.menu_home) {
                        // Clear any existing views from FrameLayout
                        fragment_container.removeAllViews()
                        // Notify adapter about the change
                        dollAdapter.notifyDataSetChanged()
                        // Fetch doll data and populate the RecyclerView
                        getDollData()
                        selectedMenuItemId = R.id.menu_home
                    }
                    true
                }
                R.id.menu_transactions -> {
                    if (selectedMenuItemId != R.id.menu_transactions) {
                        // Clear the RecyclerView when navigating to the transactions page
                        dollList.clear()
                        dollAdapter.notifyDataSetChanged()
                        startActivity(Intent(this, TransactionActivity::class.java))
                        selectedMenuItemId = R.id.menu_transactions
                    }
                    true
                }
                R.id.menu_profile -> {
                    if (selectedMenuItemId != R.id.menu_profile) {
                        // Clear the RecyclerView when navigating to the profile page
                        dollList.clear()
                        dollAdapter.notifyDataSetChanged()
                        // Inflate profile page layout
                        val profileLayout = layoutInflater.inflate(R.layout.profile_page, null)
                        fragment_container.addView(profileLayout)
                        selectedMenuItemId = R.id.menu_profile
                    }
                    true
                }
                else -> {
                    // Update selectedMenuItemId for other menu items
                    selectedMenuItemId = item.itemId
                    // Return true to indicate that the item is handled
                    true
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        recyclerView = findViewById(R.id.recycler_view)
        dollAdapter = DollAdapter(this, dollList,
            onItemClick = { doll ->
                val intent = Intent(this, DollDetailActivity::class.java)
                intent.putExtra("doll", doll)
                startActivity(intent)
            },
            onBuyClick = { doll ->
                // Handle buy click action here if needed
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = dollAdapter

        getDollData()
    }

    private fun getDollData() {
        // Fetch doll data from your database or any other source
        // For demo, I'm adding dummy data
        dollList.clear() // Clear existing data
        dollList.addAll(getDummyDollData())
        dollAdapter.notifyDataSetChanged() // Notify adapter about the change
    }

    // Dummy function to generate doll data
    private fun getDummyDollData(): List<Doll> {
        return listOf(
            Doll(
                "SNRLX",
                "Snorlax",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGpwr2HfN4VUlGjJZbQDI_S_6LpNI9Ndkz1A&usqp=CAU",
                "Large", 4.5f, 29.99, "Description 1"
            ),
            Doll(
                "PTRCK",
                "Patrick",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRriee-mWuEk9q2h0c5mYzOFjQ9yxnh6rcFDg&usqp=CAU",
                "Medium", 4.2f, 19.99, "Description 2"
            ),
            Doll(
                "SPNGB",
                "Spongebob",
                "https://media.karousell.com/media/photos/products/2023/10/23/boneka_spongebob_squarepants___1698019485_6bd22511_progressive.jpg",
                "Small", 4.0f, 9.99, "Description 3"
            )
        )
    }
}






