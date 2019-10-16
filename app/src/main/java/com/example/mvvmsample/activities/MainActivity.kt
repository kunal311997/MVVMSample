package com.example.mvvmsample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmsample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            txt.text = edt.text.toString()
        }
    }
}
