package com.example.kotlinexercise

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_contacts.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Contacts : AppCompatActivity() , ContactAdapter.OnNoteListener {
    lateinit var contactList: List<Contact>
    override fun onCreate(savedInstanctState: Bundle?){
        super.onCreate(savedInstanctState)
        setContentView(R.layout.activity_contacts)
        contactList=getContacts()
        recyclerViewContacts.layoutManager = LinearLayoutManager(this)
        recyclerViewContacts.adapter=ContactAdapter(contactList)
        swipeRefreshLayout.setOnRefreshListener {
            getContacts()
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private fun getContacts() : List<Contact>{
        swipeRefreshLayout.isRefreshing=true
        val contacts= listOf(
            Contact(id=1
                ,firstName = "Aaron Edwigg"
                ,lastName = "Custodio",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=2
                ,firstName = "Felix Alexander"
                ,lastName = "Carao",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=3
                ,firstName = "Arnold"
                ,lastName = "Mendoza",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=4
                ,firstName = "Jasper"
                ,lastName = "Orilla",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=5
                ,firstName = "Charles Kenichi"
                ,lastName = "Nazareno",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=6
                ,firstName = "Mark Kenneth"
                ,lastName = "Lomio",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=7
                ,firstName = "Kayla"
                ,lastName = "Calpito",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=8
                ,firstName = "Melrose"
                ,lastName = "Mejidana",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=9
                ,firstName = "Jelmarose"
                ,lastName = "De Vera",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg"),
            Contact(id=10
                ,firstName = "Dino Angelo"
                ,lastName = "Reyes",contactNo = "0912312312"
                ,birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,address="Manila City"
                ,imageUrl="https://www.w3schools.com/w3css/img_lights.jpg")
        )
        swipeRefreshLayout.isRefreshing=false
        return contacts



    }
    override fun onNoteClick(position: Int){
        var intent= Intent(this,)
    }
}
