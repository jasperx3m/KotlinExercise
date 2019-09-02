package com.example.kotlinexercise.Models

import java.io.Serializable
import java.time.LocalDate

data class Contact (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val contactNo: String,
    val birthday: LocalDate,
    val address: String,
    val imageUrl: String
                    ) : Serializable{
    val fullName="$firstName $lastName"
    val initials=(firstName[0].toString()+lastName[0].toString())
    val color = getColor(firstName[0])

    }
private fun getColor(Initial: Char) : String? {
    val colorMap= mapOf('A' to "#f44336",
        'B' to "#f44336",
        'C' to "#E91E63",
        'D' to "#9C27B0",
        'E' to "#673AB7",
        'F' to "#3F51B5",
        'G' to "#2196F3",
        'H' to "#03A9F4",
        'I' to "#00BCD4",
        'J' to "#009688",
        'K' to "#4CAF50",
        'L' to "#8BC34A",
        'M' to "#CDDC39",
        'N' to "#FFEB3B",
        'O' to "#FFC107",
        'P' to "#FF9800",
        'Q' to "#FF5722",
        'R' to "#795548",
        'S' to "#9E9E9E",
        'T' to "#607D8B",
        'U' to "#2196F3",
        'V' to "#00BCD4",
        'W' to "#795548",
        'X' to "#607D8B",
        'Y' to "#00E676",
        'Z' to "#E65100"
    )
    return colorMap[Initial]
}