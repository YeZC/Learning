package com.example.learningmaterials.java.annotation_processing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.learningmaterials.R
import com.yzc.reflection_annotation.BindView
import com.yzc.reflection_annotation.Binding

class AnnotationActivity : AppCompatActivity() {

    @BindView(R.id.textview1)
    private lateinit var textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_annotation)

        Binding.bind(this)

        textview.setText("yezhaochu")
    }
}