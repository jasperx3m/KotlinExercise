package com.example.kotlinexercise

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_form.*
import java.text.SimpleDateFormat
import java.util.*

class MovieForm : AppCompatActivity(), OnDateSetListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_form)
        /*inputDate.setText(SimpleDateFormat("mm/dd/yyyy").format(System.currentTimeMillis()))
        var cal = Calendar.getInstance()

        val dateSetListener = OnDateSetListener{view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val dateFormat= "mm/dd/yyyy"
            val sdf= SimpleDateFormat(dateFormat, Locale.US)
            inputDate.setText(sdf.format(cal.time))
        }
        inputDate.setOnClickListener{
            DatePickerDialog(this@MovieForm, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }*/
/*        inputDate.setText(SimpleDateFormat("mm/dd/yyyy")
            .format(System.currentTimeMillis()))*/
        inputDate.setOnClickListener{
            showDatePicker()
        }

    }
    private fun showDatePicker(){
        var calendar = Calendar.getInstance()
        var datePickerDialog = DatePickerDialog(this@MovieForm,this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()

    }

     override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
         /*var calendar= Calendar.getInstance()
         calendar.set(Calendar.YEAR, year)
         calendar.set(Calendar.MONTH, month)
         calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

         val dateFormat= "m/d/y"
         val sdf= SimpleDateFormat(dateFormat)*/
         var date = "$month/$dayOfMonth/$year"
         inputDate.setText(date)
    }
}