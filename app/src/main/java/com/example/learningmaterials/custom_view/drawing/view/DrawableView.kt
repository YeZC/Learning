package com.example.learningmaterials.custom_view.drawing.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.custom_view.dp
import com.example.learningmaterials.custom_view.drawing.drawable.MeshDrawable

class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

//    private val drawable = ColorDrawable(Color.RED)
    private val drawable = MeshDrawable()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        drawable.setBounds(50.dp.toInt(), 80.dp.toInt(), width, height)
//        drawable.draw(canvas)

        drawable.setBounds(50.dp.toInt(), 80.dp.toInt(), width, height)
        drawable.draw(canvas)
    }
}