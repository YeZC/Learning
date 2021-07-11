package com.example.learningmaterials.customView.drawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.learningmaterials.customView.drawing.dp
import kotlin.math.cos
import kotlin.math.sin

private val CIRCLE_COLOR = Color.parseColor("#90A4AE")
private val HIGHLIGHT_COLOR = Color.parseColor("#FF4081")
private val RING_WIDTH = 20.dp
private val RADIUS = 150.dp
class SportView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 100.dp
//        typeface = ResourcesCompat.getFont(context, R.font.font)
        // 字体居中
        textAlign = Paint.Align.CENTER
    }
    private val bounds = Rect()
    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        paint.color = CIRCLE_COLOR
        paint.strokeWidth = RING_WIDTH
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)

        paint.color = HIGHLIGHT_COLOR
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS,
            -90f, 225f, false, paint)

        paint.style = Paint.Style.FILL
//        paint.getTextBounds("test", 0, "test".length, bounds)
//        canvas.drawText("test", width / 2f, height / 2f - (bounds.top + bounds.bottom) / 2f, paint)

        paint.getFontMetrics(fontMetrics)
        canvas.drawText("test", width / 2f, height / 2f - (fontMetrics.ascent + fontMetrics.descent) / 2f, paint)

        paint.textAlign = Paint.Align.LEFT
        paint.getFontMetrics(fontMetrics)
        canvas.drawText("test1", - fontMetrics.leading.toFloat(), - fontMetrics.top.toFloat(), paint)

        paint.textAlign = Paint.Align.LEFT
        paint.getTextBounds("test2", 0, "test2".length, bounds)

        canvas.drawText("test2", - bounds.left.toFloat(), - bounds.top.toFloat(), paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    }

}