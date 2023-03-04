package com.azamovhud.dialoggit.classes

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.azamovhud.dialoggit.R
import kotlinx.android.synthetic.main.basic_dialog.*

class BasicDialog(context: Context) : AppCompatDialogFragment() {
    var basicDialogListeners: BasicDialogListeners? = null

    var dialogTitle: String? = null
    var mainText: String? = null
    var okBtnText: String? = null
    var cancelBtn: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.basic_dialog, null)!!
        builder.setView(view)
        val titleTv: TextView = view.findViewById(R.id.title_tv)
        val mainTextTV: TextView = view.findViewById(R.id.message_tv)
        val okBtnTV: TextView = view.findViewById(R.id.positive_btn)
        val cancelBtnTV: TextView = view.findViewById(R.id.negative_btn)

        titleTv.text = dialogTitle
        mainTextTV.text = mainText
        okBtnTV.text = okBtnText
        cancelBtnTV.text = cancelBtn

        okBtnTV.setOnClickListener {
            dismiss()
            basicDialogListeners?.okButtonClicked()
        }

        cancelBtnTV.setOnClickListener {
            dismiss()
            basicDialogListeners?.cancelButtonClicked()
        }

        return builder.create()
    }

    fun createDialog(title:String, mainTxt:String, okBtnTxt:String, cancelBtnTxt:String){
        this.dialogTitle = title
        this.mainText = mainTxt
        this.cancelBtn = okBtnTxt
        this.okBtnText = cancelBtnTxt

    }
    fun setOnButtonClickListener(listener:BasicDialogListeners){
        this.basicDialogListeners = listener
    }

    interface BasicDialogListeners {
        fun okButtonClicked()
        fun cancelButtonClicked()
    }
}
