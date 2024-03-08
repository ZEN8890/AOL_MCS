package com.example.aol_mcs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
                        selectedMenuItemId = R.id.menu_home
                        // You can optionally add any other logic specific to the home page
                    }
                    true
                }
                R.id.menu_transactions -> {
                    if (selectedMenuItemId != R.id.menu_transactions) {
                        // Handle transactions menu item click
                        startActivity(Intent(this, TransactionActivity::class.java))
                        selectedMenuItemId = R.id.menu_transactions
                    }
                    true
                }
                R.id.menu_profile -> {
                    if (selectedMenuItemId != R.id.menu_profile) {
                        // Clear any existing views from FrameLayout
                        fragment_container.removeAllViews()
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
        dollAdapter = DollAdapter(this, dollList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = dollAdapter

        dollAdapter.setOnItemClickListener { position ->
            val selectedDoll = dollAdapter.getItem(position)
            // Redirect to detail page passing doll data
            val intent = Intent(this, DollDetailActivity::class.java)
            intent.putExtra("doll", selectedDoll)
            startActivity(intent)
        }

        // Fetch doll data and populate the RecyclerView
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
//            Doll("Doll 1", R.drawable.doll1, "Large", 4.5f, 29.99, "Description 1"),
//            Doll("Doll 2", R.drawable.doll2, "Medium", 4.2f, 19.99, "Description 2"),
//            Doll("Doll 3", R.drawable.doll3, "Small", 4.0f, 9.99, "Description 3")
        )
    }

    // Function to add a new doll
    private fun addNewDoll(doll: Doll) {
        dollList.add(doll)
        dollAdapter.notifyItemInserted(dollList.size - 1)
    }
}




