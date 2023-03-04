package com.azamovhud.dialoggit.classes

import android.app.Dialog
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.view.forEach
import com.azamovhud.dialoggit.R

class CheckBoxDialog(val list: List<String>, val title: String) : AppCompatDialogFragment() {

    var listener: OnChooseClickListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = activity?.layoutInflater!!

        val view = inflater.inflate(R.layout.check_box_dialog, null)
        val linear = view.findViewById<LinearLayout>(R.id.linear)

        for (i in list) {
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 24, 0, 0)

            val checkBox = CheckBox(activity)
            checkBox.tag = i
            checkBox.text = i
            checkBox.layoutParams = params
            linear.addView(checkBox)
        }
        builder.setView(view)
        val titleTV = view.findViewById<TextView>(R.id.title_tv)
        val chooseTV = view.findViewById<TextView>(R.id.choose_tv)
        chooseTV.setOnClickListener {
            val list = arrayListOf<String>()
            linear.forEach {
                val checkBox = it as CheckBox
                if (checkBox.isChecked) {
                    list.add(checkBox.text.toString())
                }
            }
            listener?.chooseClick(list)
            dismiss()
        }

        titleTV.text = title

        return builder.create()
    }

    fun setOnChooseClickListener(listener: OnChooseClickListener) {
        this.listener = listener
    }

    interface OnChooseClickListener {
        fun chooseClick(chosenList: List<String>)
    }

}