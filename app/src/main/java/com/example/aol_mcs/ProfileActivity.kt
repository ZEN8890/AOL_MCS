package com.example.aol_mcs

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
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
        usernameTextView = findViewById(R.id.usernameTextView)
        emailTextView = findViewById(R.id.EmailTV)
        phoneNumberTextView = findViewById(R.id.PhoneTV)
        val logoutButton = findViewById<Button>(R.id.LogoutBT)

        // Display user information
        displayUserInfo()

        // Logout Button click listener
        logoutButton.setOnClickListener { v: View? -> logout() }
    }

    private fun displayUserInfo() {
        // Retrieve user information from SharedPreferences or database
        val username = sharedPreferences!!.getString("username", "")
        val email = sharedPreferences!!.getString("email", "")
        val phoneNumber = sharedPreferences!!.getString("phoneNumber", "")

        // Display user information in TextViews
        usernameTextView!!.text = "Username: $username"
        emailTextView!!.text = "Email: $email"
        phoneNumberTextView!!.text = "Phone Number: $phoneNumber"
    }

    private fun logout() {
        // Clear user session data (if any)
        val editor = sharedPreferences!!.edit()
        editor.clear()
        editor.apply()

        // Redirect to com.example.aol_mcs.LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
















