package com.example.kotlinexercise

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexercise.Adapters.ContactAdapter
import com.example.kotlinexercise.Models.Contact
import kotlinx.android.synthetic.main.activity_contacts.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Contacts : AppCompatActivity() , ContactAdapter.OnClickListener {
    lateinit var contactList: MutableList<Contact>

    override fun onCreate(savedInstanctState: Bundle?){
        super.onCreate(savedInstanctState)
        setContentView(R.layout.activity_contacts)
        contactList=getContacts()
        swipeRefreshLayout.setOnRefreshListener {
            contactList=getContacts()
            addListToRecyclerView()
        }
        addListToRecyclerView()
    }
    private fun addListToRecyclerView(){
        recyclerViewContacts.layoutManager = LinearLayoutManager(this)
        recyclerViewContacts.adapter= ContactAdapter(contactList, this)
        ItemTouchHelper(SwipeToDeleteCallBack(this)).attachToRecyclerView(recyclerViewContacts)
    }
    @TargetApi(Build.VERSION_CODES.O)
    private fun getContacts() : MutableList<Contact>{
        swipeRefreshLayout.isRefreshing=true
        val contacts= mutableListOf(
            Contact(
                id = 1
                , firstName = "Aaron Edwigg"
                , lastName = "Custodio", contactNo = "0912312312"
                , birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                , address = "Manila City"
                , imageUrl = "https://www.w3schools.com/w3css/img_lights.jpg"
            ),
            Contact(
                id = 2
                ,
                firstName = "Felix Alexander"
                ,
                lastName = "Carao",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "https://d1yn1kh78jj1rr.cloudfront.net/image/thumbnail/rGMF3jSims9o98x/storyblocks-flowers-in-a-garden-against-blue-sky-bottom-view_r8CAusDJM_thumb.jpg"
            ),
            Contact(
                id = 3
                ,
                firstName = "Arnold"
                ,
                lastName = "Mendoza",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "https://www.belightsoft.com/products/imagetricks/img/intro-video-poster@2x.jpg"
            ),
            Contact(
                id = 4
                ,
                firstName = "Jasper"
                ,
                lastName = "Orilla",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
            ),
            Contact(
                id = 5
                ,
                firstName = "Charles Kenichi"
                ,
                lastName = "Nazareno",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg"
            ),
            Contact(
                id = 6
                , firstName = "Mark Kenneth"
                , lastName = "Lomio", contactNo = "0912312312"
                , birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                , address = "Manila City"
                , imageUrl = "https://www.w3schools.com/howto/img_snow.jpg"
            ),
            Contact(
                id = 7
                ,
                firstName = "Kayla"
                ,
                lastName = "Calpito",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "http://www.sarkarinaukrisearch.in/wp-content/uploads/2018/12/tetty-bear-image-24.gif"
            ),
            Contact(
                id = 8
                ,
                firstName = "Melrose"
                ,
                lastName = "Mejidana",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "https://res.cloudinary.com/demo/image/upload/c_imagga_crop/family_bench.jpg"
            ),
            Contact(
                id = 9
                ,
                firstName = "Jelmarose"
                ,
                lastName = "De Vera",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
            ),
            Contact(
                id = 10
                ,
                firstName = "Dino Angelo"
                ,
                lastName = "Reyes",
                contactNo = "0912312312"
                ,
                birthday = LocalDate.parse("1998-09-25", DateTimeFormatter.ISO_DATE)
                ,
                address = "Manila City"
                ,
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTD0I5vyOjjRW65N-tfqenZwvh9wEqyngk5oyQR78szVyE03ZYCg"
            )
        )
        swipeRefreshLayout.isRefreshing=false
        return contacts

    }
    override fun onContactClick(position: Int){

        var intent= Intent(this,ContactDetails::class.java)

        startActivity(intent.putExtra("contact",contactList[position]))
    }

    override fun onContactLongClick(position: Int) {
        deleteContact(position)
    }
    private fun deleteContact(position: Int){
        Toast.makeText(this," ${contactList[position].firstName} Deleted", Toast.LENGTH_LONG).show()
        contactList.removeAt(position)
        addListToRecyclerView()
    }
    inner  class SwipeToDeleteCallBack(context: Context) : ItemTouchHelper.SimpleCallback(0, RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            deleteContact(viewHolder.adapterPosition)
        }
    }
}
