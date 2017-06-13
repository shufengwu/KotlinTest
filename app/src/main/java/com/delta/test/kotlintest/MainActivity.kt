package com.delta.test.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        var text: String = "hehe"
        tv_content.text = text
        btn_test.setOnClickListener {
            var toastContent :String ="success!"
            Toast.makeText(this,toastContent,Toast.LENGTH_SHORT).show()
        }
    }
}
