package com.example.kotlinexercise.Models

import java.io.Serializable

data class Products (
    val id : Int,
    val name: String,
    val description : String,
    val price : Double,
    val imageUrl : String,
    val isActive : Boolean
) : Serializable