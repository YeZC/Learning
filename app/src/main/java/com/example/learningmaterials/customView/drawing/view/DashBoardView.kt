package com.example.learningmaterials.customView.drawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.customView.drawing.dp
import kotlin.math.cos
import kotlin.math.sin

class DashBoardView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    val MASK = 10
    val RADIUS = 150f.dp
    val LENGTH = 120f.dp
    val OPEN_ANGLE = 120f
    val DASH_WIDTH = 2f.dp
    val DASH_LENGTH = 10f.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val dashPath = Path()
    private lateinit var pathEffect: PathDashPathEffect

    init {
        paint.strokeWidth = 3f.dp
        paint.style = Paint.Style.STROKE
        dashPath.addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
        paint.pathEffect = pathEffect
        canvas.drawPath(path, paint)
        paint.pathEffect = null

        canvas.drawLine(width / 2f,
            height / 2f,
            (width / 2f + LENGTH * cos(markToRadians(MASK))).toFloat(),
            (height / 2f + LENGTH * sin(markToRadians(MASK))).toFloat(),
            paint
        )
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addArc(width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS,
            90f + OPEN_ANGLE / 2f,
            360f - OPEN_ANGLE)
        val pathMeasure = PathMeasure(path, false)
        pathEffect = PathDashPathEffect(dashPath, (pathMeasure.length - DASH_WIDTH) / 20f, 0f, PathDashPathEffect.Style.ROTATE)
    }

    private fun markToRadians(mark: Int) = Math.toRadians((90 + OPEN_ANGLE / 2f + (360 - OPEN_ANGLE) / 20f * mark).toDouble())

}