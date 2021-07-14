package com.example.learningmaterials.customView.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningmaterials.R

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 图形的位置和尺寸测量
        // Xfermode
        // 文字测量
        // 范围裁切和几何变换
        setContentView(R.layout.activity_custom_view)
    }

}