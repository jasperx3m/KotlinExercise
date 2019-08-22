package com.example.kotlinexercise

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_quoteslider.*

class QuoteSlider : AppCompatActivity() {
    private var quotes =arrayOf("red","green","blue","yellow","penk")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quoteslider)
        seekBar.max=72
        seekBar.min=10

        var index: Int=0
        ChangeQuote(index)
        btnNext.setOnClickListener(){
            index++
            if (index==quotes.size){
                index=0
            }
            ChangeQuote(index)

        }
        btnBack.setOnClickListener(){
            index--
            if(index==-1){
                index=quotes.size-1
            }
            ChangeQuote(index)
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

            override fun onProgressChanged(seekBar: SeekBar?, size: Int, b: Boolean) {
                txtFontSize.text = "Font Size: $size"
                textView.textSize=size.toFloat()
            }
        })


    }
    public fun ChangeQuote(index: Int){
        textView.text=quotes[index]
    }


}