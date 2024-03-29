package com.example.learningmaterials.architecture.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningmaterials.R
import com.example.learningmaterials.architecture.mvc.DataCenter
import kotlinx.android.synthetic.main.activity_mvc.*

class MvvmActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)

        ViewModel(data1View, data2View).init()
    }

}