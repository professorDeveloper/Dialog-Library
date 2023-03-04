package com.example.dialoggit.classes

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import com.example.dialoggit.R
import com.google.android.material.tabs.TabLayout

class DateAndTimeDialog : AppCompatDialogFragment() {

    var listener: OnButtonClicked? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }
        val inflater = activity?.layoutInflater

        val view = inflater?.inflate(R.layout.data_dialog, null)!!

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        val positiveTv = view.findViewById<TextView>(R.id.positive_btn)
        val negativeTv = view.findViewById<TextView>(R.id.negative_btn)
        val datePicker = view.findViewById<DatePicker>(R.id.date_picker)
        val timePicker = view.findViewById<TimePicker>(R.id.time_picker)
        timePicker.setIs24HourView(true)

        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == 0) {
                    datePicker.visibility = View.VISIBLE
                    timePicker.visibility = View.GONE
                } else {
                    datePicker.visibility = View.GONE
                    timePicker.visibility = View.VISIBLE
                    positiveTv.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            com.google.android.material.R.color.design_default_color_primary
                        )
                    )
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        positiveTv.setOnClickListener {
            if (positiveTv.currentTextColor == ContextCompat.getColor(
                    requireContext(),
                    com.google.android.material.R.color.design_default_color_primary
                )
            ) {
                listener?.OnOkButtonClicked(datePicker, timePicker)
                dismiss()
            }
        }
        negativeTv.setOnClickListener { dismiss() }

        builder!!.setView(view)

        return builder!!.create()
    }

    fun setOnOkButtonClicked(listener: OnButtonClicked) {
        this.listener = listener
    }

    interface OnButtonClicked {
        fun OnOkButtonClicked(datePicker: DatePicker, timePicker: TimePicker)
    }

}