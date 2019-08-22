package com.example.kotlinexercise

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_colorpicker.*

class ColorPicker : AppCompatActivity(){

    private var red: Int = 0
    private var green: Int = 0
    private var blue: Int = 0
    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colorpicker)

    seekBarRed.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(p0: SeekBar?, value: Int, b: Boolean) {
            red=value
            textViewRed.text="Blue: $value"
            ChangeColor()
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

    seekBarGreen.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(p0: SeekBar?, value: Int, b: Boolean) {
            green=value
            textViewGreen.text="Green: $value"
            ChangeColor()
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

    seekBarBlue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
         override fun onProgressChanged(p0: SeekBar?, value: Int, b: Boolean) {
             blue=value
             textViewBlue.text="Blue: $value"
             ChangeColor()
         }

         override fun onStartTrackingTouch(p0: SeekBar?) {}
         override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    private fun ChangeColor(){
        cardView.setCardBackgroundColor(Color.rgb(red,green,blue))
    }
}

