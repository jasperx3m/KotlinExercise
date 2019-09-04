package com.example.kotlinexercise.Models

import java.io.Serializable

data class Products (
    val id : String,
    val name: String,
    val description : String,
    val price : String,
    val imageUrl : String,
    val isActive : String
) : Serializable

data class PostProducts(
    val name: String,
    val description : String,
    val price : String,
    val imageUrl : String,
    val isActive : String
)