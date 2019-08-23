package com.example.kotlinexercise

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_images.*
import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.R
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions



class Images : AppCompatActivity(){
    /*private val circularProgressDrawable = CircularProgressDrawable(this)*/
    private val url
            = arrayOf("https://tinyurl.com/yypw59xh",
                      "https://tinyurl.com/y3bydso9",
                      "https://tinyurl.com/yyuywv5l",
                      "https://tinyurl.com/y22razxu",
                      "https://tinyurl.com/y2hvt72y",
                      "https://tinyurl.com/y5hdz9l6",
                      "https://tinyurl.com/y697jezg",
                      "https://tinyurl.com/y6t2pfdv",
                      "https://tinyurl.com/y2nt9kt9")
    var index: Int=0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        getImage()
/*
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
*/
    }
     fun loadImageUrl(view: View){
        var button: Button = findViewById(view.id)
        if (button.id==(btnNext.id)){
            if (index==8){
                index=0
            }
            index++
        }
        else if (button.id==(btnBack.id)){
            if (index==0){
                index=8
            }
            index--
        }
        getImage()
    }
    private fun getImage(){
        Glide.with(this)
            .load(url[index])
            .into(imageView)
    }
    var options = RequestOptions()
        .centerCrop()
        .placeholder(res.drawable.)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .dontAnimate()
        .dontTransform()
}
