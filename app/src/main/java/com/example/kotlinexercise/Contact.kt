package com.example.kotlinexercise

import android.graphics.Color
import androidx.core.graphics.toColor
import java.time.LocalDate
import java.util.*

data class Contact (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val contactNo: String,
    val birthday: LocalDate,
    val address: String,
    val imageUrl: String
                    ){
    val fullName="${firstName} ${lastName}"
    val initials=(firstName[0].toString()+lastName[0].toString())


    }