package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    var itemFeedback: String = "JOD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.getFees)
        val editText1: EditText = findViewById(R.id.hoursNum)
        val feesTV: TextView = findViewById(R.id.fees)
        var perHour: Double
        var semesterFee: Double = 0.0
        val radioGroup : RadioGroup = findViewById(R.id.SemesterRadio)


        var flag1 : String = "Accounting"
        var flag2 : String =""

        val spinnerVal : Spinner = findViewById(R.id.spinner01)

        var majors = arrayOf("Accounting","Computer Science", "Cyber Security", "Data Science")
        var semester = arrayOf("Normal Semester", "Summer Semester")


        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,majors)








        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag1 = majors.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }



        button.setOnClickListener{ view ->
            var x = editText1.text.toString().toDouble()

            if(flag1 =="Accounting")
                perHour = 90.00
            else if(flag1=="E-Marketing")
                perHour = 95.00
            else if(flag1=="Computer Science")
                perHour = 100.00
            else if(flag1=="Cyber Security")
                perHour = 110.00
            else
                perHour = 120.00

          val selectedOption: Int = radioGroup.checkedRadioButtonId
          val radioButton : RadioButton = findViewById(selectedOption)


          flag2 = radioButton.text.toString()

            if(flag2 == "Normal Semester")
                semesterFee = 300.00
            else
                semesterFee = 150.00



            if(itemFeedback == "JOD")
            feesTV.text = calc(x,perHour,semesterFee).toString() + " JOD"

            else
                feesTV.text = calc(x,perHour,semesterFee).toString() + " USD"






        }


    }

public fun calc(a: Double, b: Double, c: Double): Double {
    if(itemFeedback == "JOD")
       return c + a*b
    else
        return (c + a*b)*1.41
}

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.sections_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var dialog_var = InfoDialogClass()
        when(item.itemId){
            R.id.item1 -> dialog_var.show(supportFragmentManager, "Prices Information Dialog")
            R.id.item2 -> Toast.makeText(this, "JOD Currency Selected", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "USD Currency Selected", Toast.LENGTH_SHORT).show()
        }
        when(item.itemId){
            R.id.item2 -> itemFeedback="JOD"
            R.id.item3 -> itemFeedback="USD"
        }
        return true;
    }

   fun receiveFeedback(feedback: String) :String {
       val semesterType : String = feedback
       return semesterType


    }


}
