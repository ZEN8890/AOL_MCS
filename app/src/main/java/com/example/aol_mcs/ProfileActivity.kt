package com.example.aol_mcs

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    private var sharedPreferences: SharedPreferences? = null
    private var usernameTextView: TextView? = null
    private var emailTextView: TextView? = null
    private var phoneNumberTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_page)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)

        // Initialize views
        usernameTextView = findViewById(R.id.usernameTitleTextView)
        emailTextView = findViewById(R.id.emailtitleTextView)
        phoneNumberTextView = findViewById(R.id.phoneNumbertitleTextView)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        // Display user information
        displayUserInfo()

        // Logout Button click listener
        logoutButton.setOnClickListener { logout() }
    }

    private fun displayUserInfo() {
        // Retrieve user information from SharedPreferences
        val username = sharedPreferences!!.getString("username", "")
        val email = sharedPreferences!!.getString("email", "")
        val phoneNumber = sharedPreferences!!.getString("phoneNumber", "")

        // Display user information in TextViews
        usernameTextView!!.text = "Username"
        emailTextView!!.text = "Email: $email"
        phoneNumberTextView!!.text = "Phone Number: $phoneNumber"

        val usernametv = findViewById<TextView>(R.id.usernamebox)
        val emailtv = findViewById<TextView>(R.id.emailbox)
        val phonetv = findViewById<TextView>(R.id.pnbox)
        usernametv.text = username
        emailtv.text = email
        phonetv.text = phoneNumber
    }

    private fun logout() {
        // Clear user session data
        val editor = sharedPreferences!!.edit()
        editor.clear()
        editor.apply()

        // Redirect to LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Finish the current activity to prevent going back to it on back press
    }
}






















