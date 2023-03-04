package com.azamovhudstc.dialoglibrary

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.azamovhud.dialoggit.classes.BasicDialog
import com.azamovhud.dialoggit.classes.CheckBoxDialog
import com.azamovhud.dialoggit.classes.ColorDialog
import com.azamovhud.dialoggit.classes.WifiDialog
import com.azamovhudstc.dialoglibrary.databinding.ActivityMainBinding
import com.azamovhud.dialoggit.classes.DateAndTimeDialog

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.basicDialog.setOnClickListener {
           basicDialog()
       }

       binding.dateDialog.setOnClickListener {
           dateDialog()
       }

       binding.colorsheetDialog.setOnClickListener {
           colorDialog()
       }

       binding.checkboxDialog.setOnClickListener {
           openCheckBoxDialog()
       }

       binding.wifiDialog.setOnClickListener {
           wifiDialog()
       }


    }

   private fun wifiDialog() {
       val dialog = WifiDialog()
       dialog.show(supportFragmentManager, "wifi_dialog")
       dialog.createDialog("Google wifi", "Pixel 2 A", "i929uui4ui", "Wpa2")
       dialog.setonButtonsCLickedListener(object : WifiDialog.WiFiDialogListeners {
           override fun okButtonClicked(password: String) {
               Toast.makeText(this@MainActivity, "$password", Toast.LENGTH_SHORT).show()
           }
           override fun cancelButtonClicked() {}
       })


   }

   private fun colorDialog() {
       val dialog = ColorDialog()
       dialog.show(supportFragmentManager, "color_dialog")
       dialog.setOnColorSelectedListener(object : ColorDialog.OnColorSelectListener {
           override fun OnColorSelected(color: Int) {
               binding.colorsheetDialog.setBackgroundColor(color)
           }

       })
   }

   private fun dateDialog() {
       val dialog = DateAndTimeDialog()
       dialog.show(supportFragmentManager, "date_dialog")
       dialog.setOnOkButtonClicked(object : DateAndTimeDialog.OnButtonClicked {
           @RequiresApi(Build.VERSION_CODES.M)
           override fun OnOkButtonClicked(datePicker: DatePicker, timePicker: TimePicker) {
               val date = "${datePicker.dayOfMonth}.${datePicker.month}.${datePicker.year}  " +
                       "${timePicker.hour}:${timePicker.minute}"
               Toast.makeText(this@MainActivity, date, Toast.LENGTH_SHORT).show()
           }


       })
   }

   private fun basicDialog() {
       val basicDialog = BasicDialog(this)
       basicDialog.createDialog(
           title = "Lorem ipsum?",
           mainTxt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                   "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
           okBtnTxt = "Agree",
           cancelBtnTxt = "Disagree"
       )
       basicDialog.show(supportFragmentManager, "basic_dialog")
       basicDialog.setOnButtonClickListener(object : BasicDialog.BasicDialogListeners {
           override fun okButtonClicked() {
               Toast.makeText(this@MainActivity, "DISAGREE", Toast.LENGTH_SHORT).show()

           }

           override fun cancelButtonClicked() {
               Toast.makeText(this@MainActivity, "AGREE", Toast.LENGTH_SHORT).show()

           }

       })
   }

   private fun openCheckBoxDialog() {
       val list = arrayListOf("Twitter", "Google", "Instagram", "Facebook")

       val checkBoxDialog = CheckBoxDialog(list, "Social medias")
       checkBoxDialog.setOnChooseClickListener(object : CheckBoxDialog.OnChooseClickListener {
           override fun chooseClick(chosenList: List<String>) {
               val stringBuilder = StringBuilder()
               for (i in list) {
                   stringBuilder.append("$i ")
               }
               Toast.makeText(this@MainActivity, stringBuilder.toString(), Toast.LENGTH_SHORT)
                   .show()
           }

       })
       checkBoxDialog.show(supportFragmentManager, "checkbox_dialog")
   }

}