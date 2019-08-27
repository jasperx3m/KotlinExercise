package com.example.kotlinexercise

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_contacts.view.*


class ContactAdapter(val contacts: List<Contact>):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    override fun  onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_contacts,parent,false)
        )
    }

    override fun getItemCount(): Int = contacts.size


    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact=contacts[position]
        holder.itemView.textViewName.text=contact.fullName
        holder.itemView.textViewNumber.text=contact.contactNo
        holder.itemView.textViewInitials.text=contact.initials
        holder.itemView.circle.setCardBackgroundColor(Color.parseColor(getColor(contact.firstName[0])))
    }

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view)

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
    class ViewHolder : RecyclerView.ViewHolder(), View.OnClickListener{
        public ViewHolder(itemView: View){
            super(itemView)
        }
        override fun onClick(p0: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
    interface OnNoteListener{
         fun onNoteClick(position: Int)
    }
}