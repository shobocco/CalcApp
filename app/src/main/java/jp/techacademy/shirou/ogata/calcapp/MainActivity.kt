package jp.techacademy.shirou.ogata.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log


class MainActivity : AppCompatActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener(this)
        button_sub.setOnClickListener(this)
        button_mul.setOnClickListener(this)
        button_div.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        if(editText1.text.toString().length > 0 && editText2.text.toString().length > 0) {
            val input1:Double = editText1.text.toString().toDouble()
            val input2:Double = editText2.text.toString().toDouble()
            var output:Double = 0.0;

            when (v.id) {
                R.id.button_add -> {
                    output = input1 + input2

                }
                R.id.button_sub ->{
                    output = input1 - input2
                }
                R.id.button_mul ->{
                    output = input1 * input2
                }
                R.id.button_div ->{
                    if(input2 == 0.0){
                        Snackbar.make(v, "0で割ることはできません", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show()
                        return
                    }else{
                        output = input1 / input2
                    }

                }
            }
            val intent = Intent(this, result::class.java)
            intent.putExtra("OUTPUT", output)
            startActivity(intent)
            Log.d("Calc", "$output")

        }else {
            Snackbar.make(v, "数値を入力してからボタンを押してください", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
