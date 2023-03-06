# Dialog-Library
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=24)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)


## Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
	
	        implementation 'com.github.professorDeveloper:Dialog-Library:1.0.3'

}
```
<h1>Material Dialog-Library</h1>

<h3>Wifi Dialog</h3>

```kotlin
       
           val dialog = WifiDialog()
       dialog.show(supportFragmentManager, "wifi_dialog")
       dialog.createDialog("Google wifi", "Pixel 2 A", "i929uui4ui", "Wpa2")
       dialog.setonButtonsCLickedListener(object : WifiDialog.WiFiDialogListeners {
           override fun okButtonClicked(password: String) {
               Toast.makeText(this@MainActivity, "$password", Toast.LENGTH_SHORT).show()
           }
           override fun cancelButtonClicked() {}
       })
      
```
<h3>Color Dialog</h3>

```kotlin
               val dialog = ColorDialog()
       dialog.show(supportFragmentManager, "color_dialog")
       dialog.setOnColorSelectedListener(object : ColorDialog.OnColorSelectListener {
           override fun OnColorSelected(color: Int) {
               binding.colorsheetDialog.setBackgroundColor(color)
           }

       })
```
<h3>Dialog Bassic</h3>

```kotlin
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
```

<h3>Date Dialog</h3>

```kotlin
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
```


## Screenshot

![Untitled (2)](https://user-images.githubusercontent.com/108933534/222921972-fce8f015-48d6-4673-a444-792afda253b8.png)

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2020 ProfessorDveloper Library

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
