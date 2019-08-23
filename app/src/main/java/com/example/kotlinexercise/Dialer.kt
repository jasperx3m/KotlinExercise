package com.example.kotlinexercise

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dialer.*

class Dialer : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialer)
        dialerText.text=""
    }
    fun AddNumberToTextView(view: View){
        var button: Button = findViewById(view.id)
        dialerText.text= dialerText.text.toString()+button.text

    }
    fun Clear(view: View){
        dialerText.text=""
    }



}

