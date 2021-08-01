package com.example.learningmaterials.custom_view.drawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.custom_view.dp
import kotlin.math.cos
import kotlin.math.sin

class PieView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private val OFFSET_LENGTH = 20f.dp
    val RADIUS = 150f.dp
    val ANGLES = floatArrayOf(60f, 90f, 150f, 60f)
    val COLORS = listOf(
        Color.parseColor("#C2185B"),
        Color.parseColor("#00ACC1"),
        Color.parseColor("#558B2F"),
        Color.parseColor("#5D4037")
    )
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        var startAngle = 0f
        for((index, angle) in ANGLES.withIndex()){
            paint.color = COLORS[index]
            if(index == 1){
                canvas.save()
                canvas.translate((OFFSET_LENGTH * cos(Math.toRadians((startAngle + angle / 2).toDouble()))).toFloat(),
                    (OFFSET_LENGTH * sin(Math.toRadians((startAngle + angle / 2).toDouble()))).toFloat()
                )
            }
            canvas.drawArc(width / 2f - RADIUS,
                height / 2f - RADIUS,
                width / 2f + RADIUS,
                height / 2f + RADIUS,
                startAngle,
                angle, true, paint)
                startAngle += angle
            if(index == 1) canvas.restore()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    }

}