package com.azamovhud.dialoggit.classes

import android.app.Dialog
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import com.azamovhud.dialoggit.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class WifiDialog : AppCompatDialogFragment() {

    var signalValue: String? = null
    var ssidValue: String? = null
    private var securityValue: String? = null
    var wifiName: String? = null
    var listener: WiFiDialogListeners? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = BottomSheetDialog(requireContext())
        val view = activity?.layoutInflater?.inflate(R.layout.wifi_dialog, null)
        builder.setContentView(view!!)

        val signal = view.findViewById<TextView>(R.id.signal_value)
        val ssid = view.findViewById<TextView>(R.id.ssid_value)
        val security = view.findViewById<TextView>(R.id.security_value)
        val wifi = view.findViewById<TextView>(R.id.wifi_name)
        val posBtn = view.findViewById<TextView>(R.id.connect_btn)
        val negBtn = view.findViewById<TextView>(R.id.cancel_button)
        val pass = view.findViewById<TextView>(R.id.edit_query)
        val checkBox = view.findViewById<CheckBox>(R.id.checkbox)

        signal.text = signalValue
        ssid.text = ssidValue
        security.text = securityValue
        wifi.text = wifiName
        posBtn.setOnClickListener {
            listener!!.okButtonClicked(pass.text.toString())
            dismiss()

        }

        negBtn.setOnClickListener {
            listener!!.cancelButtonClicked()
            dismiss()
        }
        pass.transformationMethod = PasswordTransformationMethod()
        checkBox.findViewById<CheckBox>(R.id.checkbox)
            ?.setOnCheckedChangeListener { buttonView, isChecked ->
                if (!isChecked) {
                    pass.transformationMethod = PasswordTransformationMethod();

                } else {
                    pass.transformationMethod = null;

                }
            }

        return builder
    }

    fun createDialog(
        wifiName: String,
        signal: String,
        ssid: String,
        security: String,

        ) {

        this.wifiName = wifiName
        this.signalValue = signal
        this.securityValue = security
        this.ssidValue = ssid

    }

    fun setonButtonsCLickedListener(listener: WiFiDialogListeners) {
        this.listener = listener
    }


    interface WiFiDialogListeners {
        fun okButtonClicked(password: String)
        fun cancelButtonClicked()

    }

}
