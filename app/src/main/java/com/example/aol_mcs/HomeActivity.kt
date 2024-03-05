package com.example.aol_mcs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var dollRecyclerView: RecyclerView
    private lateinit var dollAdapter: DollAdapter
    private val dollList = ArrayList<Doll>() // Assuming Doll class is already defined

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        // Initialize RecyclerView
        dollRecyclerView = findViewById(R.id.dollRecyclerView)
        dollRecyclerView.layoutManager = LinearLayoutManager(this)
        dollAdapter = DollAdapter(dollList) { selectedDoll ->
            redirectToDollDetail(selectedDoll)
        }
        dollRecyclerView.adapter = dollAdapter

        // Fetch doll data from the application's database
        fetchDollData()
    }

    private fun fetchDollData() {
        // Assuming you have a method to fetch doll data from the database
        // and populate dollList with it
        // Example:
        // dollList.addAll(database.getDolls())
    }

    private fun redirectToDollDetail(selectedDoll: Doll) {
        // Redirect to the corresponding doll detail page
        // Example:
        // val intent = Intent(this, DollDetailActivity::class.java)
        // intent.putExtra("dollId", selectedDoll.id)
        // startActivity(intent)
        Toast.makeText(this, "Clicked on ${selectedDoll.name}", Toast.LENGTH_SHORT).show()
    }
}


