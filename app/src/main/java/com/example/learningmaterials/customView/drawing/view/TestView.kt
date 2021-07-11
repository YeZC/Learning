package com.example.learningmaterials.customView.drawing.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.customView.drawing.dp

private val RADIUS = 100f.dp
class TestView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val path = Path()
    val pathMeasure = PathMeasure()

    override fun onDraw(canvas: Canvas) {
//        canvas.drawLine(100f, 100f, 200f, 200f, paint)
//        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)
        canvas.drawPath(path, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addCircle(width / 2f, height / 2f, RADIUS, Path.Direction.CCW)
        path.addRect(width / 2f - RADIUS, height / 2f , width / 2 + RADIUS, height / 2f + 2 * RADIUS, Path.Direction.CCW)
//        pathMeasure.length
//        pathMeasure.getPosTan()
        path.fillType = Path.FillType.EVEN_ODD
    }
}