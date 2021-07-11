package com.example.learningmaterials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.learningmaterials.customView.activity.CustomViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_customview_activity).apply {
            setOnClickListener {
                startActivity(Intent(context, CustomViewActivity::class.java))
            }
            performClick()
        }

    }
}
