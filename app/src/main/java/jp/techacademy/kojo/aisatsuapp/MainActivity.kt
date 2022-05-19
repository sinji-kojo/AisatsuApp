package jp.techacademy.kojo.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                when {
                    hour >= 0 && hour <= 1 -> { textView.text = "こんばんは" }
                    hour >= 2 && hour <= 9 -> { textView.text = "おはよう" }
                    hour >= 10 && hour <= 17 -> { textView.text = "こんにちは" }
                    hour >= 18 && hour <= 23 -> { textView.text = "こんばんは" }
                    else -> textView.text = "なんでじゃ"
                }
            },
                12, 0, true
        )
        timePickerDialog.show()
    }
}