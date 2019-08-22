package com.example.kotlinexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEx1.setOnClickListener{
            startActivity(Intent(this,QuoteSlider::class.java))
        }
        btnEx2.setOnClickListener{
            startActivity(Intent(this,ColorPicker::class.java))
        }
        btnEx3.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
        btnEx4.setOnClickListener{
            startActivity(Intent(this, Instagram::class.java))
        }
    }
}