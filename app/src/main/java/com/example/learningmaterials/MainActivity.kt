package com.example.learningmaterials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.learningmaterials.custom_view.activity.DrawActivity
import com.example.learningmaterials.custom_view.activity.LayoutActivity
import com.example.learningmaterials.custom_view.activity.TouchFeedbackActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_customview_activity).apply {
            setOnClickListener {
                // draw
//                startActivity(Intent(context, DrawActivity::class.java))
                // layout
//                startActivity(Intent(context, LayoutActivity::class.java))
                // touch feedback
                startActivity(Intent(context, TouchFeedbackActivity::class.java))
                finish()
            }
            performClick()
        }

    }
}
