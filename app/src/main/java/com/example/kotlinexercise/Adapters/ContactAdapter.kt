package com.example.kotlinexercise.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexercise.Models.Contact
import com.example.kotlinexercise.R
import kotlinx.android.synthetic.main.layout_contacts.view.*

class ContactAdapter (private var contacts: List<Contact>, private var onClickListener: OnClickListener):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun  onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_contacts, parent, false),
            onClickListener
        )
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact=contacts[position]
        holder.itemView.textViewName.text=contact.fullName
        holder.itemView.textViewNumber.text=contact.contactNo
        holder.itemView.textViewInitials.text=contact.initials
        holder.itemView.detailCircle.setCardBackgroundColor(Color.parseColor(contact.color))
    }


    companion object{

        fun setOnClickListener(onClickListener: OnClickListener): OnClickListener{
            return onClickListener
        }
    }


    class ContactViewHolder(itemView: View
                            , var onClickListener: OnClickListener) : RecyclerView.ViewHolder(itemView)
                                                                , View.OnClickListener
                                                                , View.OnLongClickListener{

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }
        override fun onClick(view: View) {
            onClickListener.onContactClick(adapterPosition)
        }
        override fun onLongClick(view: View): Boolean {
            onClickListener.onContactLongClick(adapterPosition)
            return true
        }

    }

    interface OnClickListener{
         fun onContactClick(position: Int)
         fun onContactLongClick(position: Int)
    }
}