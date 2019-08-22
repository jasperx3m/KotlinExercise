package com.example.kotlinexercise

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_instagram.*

class Instagram : AppCompatActivity(){

    override fun onCreate(savedInstance: Bundle?){
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_instagram)

        textViewJustify.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }

}