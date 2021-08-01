package com.example.learningmaterials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.learningmaterials.custom_view.activity.DrawActivity
import com.example.learningmaterials.custom_view.activity.LayoutActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_customview_activity).apply {
            setOnClickListener {
//                startActivity(Intent(context, DrawActivity::class.java))
                startActivity(Intent(context, LayoutActivity::class.java))
            }
            performClick()
        }

    }
}
