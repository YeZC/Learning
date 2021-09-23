package com.example.learningmaterials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.learningmaterials.architecture.mvc.MvcActivity
import com.example.learningmaterials.architecture.mvp.MvpActivity
import com.example.learningmaterials.architecture.mvvm.MvvmActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_customview_activity).apply {
            setOnClickListener {
//                startActivity(Intent(context, DrawActivity::class.java))
//                startActivity(Intent(context, LayoutActivity::class.java))


//                startActivity(Intent(context, MvcActivity::class.java))
//                startActivity(Intent(context, MvpActivity::class.java))
                startActivity(Intent(context, MvvmActivity::class.java))
            }
            performClick()
        }

    }
}
