package com.example.learningmaterials.architecture.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningmaterials.R
import kotlinx.android.synthetic.main.activity_mvc.*

class MvcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)

        val data =
            DataCenter.getData()
        data1View.setText(data[0])
        data2View.setText(data[1])
    }
}