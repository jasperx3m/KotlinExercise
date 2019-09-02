package com.example.kotlinexercise

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlinexercise.Models.Contact
import kotlinx.android.synthetic.main.activity_contact_details.*
import kotlinx.android.synthetic.main.activity_contact_details.detailImage

class ContactDetails : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        val contact = intent.getSerializableExtra("contact") as Contact
        detailNumber.text=contact.contactNo
        detailName.text=contact.fullName
        detailAddress.text=contact.address
        detailBirthday.text=contact.birthday.toString()
        detailCircle.setCardBackgroundColor(Color.parseColor(contact.color))
        detailInitials.text= contact.initials
        getImage(contact.imageUrl)
    }
    private fun getImage(url: String){
        var circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .placeholder(circularProgressDrawable)
            .into(detailImage)
    }
}