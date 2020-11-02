package jp.techacademy.shirou.ogata.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_result.*

class result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textView2.text = "%.5f".format(intent.getDoubleExtra("OUTPUT", 0.0))
    }
}
