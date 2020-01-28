package com.berntsson.blinkled

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)
        val username = findViewById<EditText>(R.id.username_in)
        val password = findViewById<EditText>(R.id.password_in)
        val login_button = findViewById<Button>(R.id.login_button)

        login_button.setOnClickListener {
            Log.d("Log", username.text.toString())
            Log.d("Log", password.text.toString())
            if (username.text.toString().equals("user") && password.text.toString().equals("password")){
                finish()
            }
        }

    }
}