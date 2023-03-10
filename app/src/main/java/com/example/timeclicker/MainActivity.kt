package com.example.timeclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TimePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickTime()
    }

    private fun onClickTime(){
        val textView = findViewById<TextView>(R.id.textView)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)

        timePicker.setOnTimeChangedListener { view, hour, minute -> var hour = hour
                    var am_pm = ""
            when{hour == 0 -> {hour += 12
                am_pm ="AM"
            }
                hour == 12 -> am_pm = "PM"
                hour >12 -> { hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }

            if (textView != null){
                val hour = if(hour<10) "0" + hour else hour
                val min = if (minute < 10 ) "0" + minute else minute

                // Display Format of Time

                val msg = "Time is : $hour : $min $am_pm"
                textView.text = msg
                textView.visibility = ViewGroup.VISIBLE
            }
        }

    }
}