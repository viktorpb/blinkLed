package com.berntsson.blinkled

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val buttonOn = findViewById<Button>(R.id.btn_click_me)
        val buttonOff = findViewById<Button>(R.id.btn_click_me_off)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.1.93/on"
        val urlOff = "http://192.168.1.93/off"

        // Request a string response from the provided URL.
        val onRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response}"
            },
            Response.ErrorListener { error ->
                textView.text = "That didn't work!"
                Log.d("Error.Response", error.toString())
            })

        val offRequest = StringRequest(
            Request.Method.POST, urlOff,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response}"
            },
            Response.ErrorListener { error ->
                textView.text = "That didn't work!"
                Log.d("Error.Response", error.toString())
            })

        // Add the request to the RequestQueue.
        buttonOn.setOnClickListener {
            queue.add(onRequest)
        }

        buttonOff.setOnClickListener {
            queue.add(offRequest)
        }

        fun http_req(url: String){

        }


    }
}
