package com.example.learningmaterials.custom_view.drawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.custom_view.dp

class XfermodeView(context: Context?, attrs: AttributeSet?) :
        View(context, attrs) {

    private val paint = Paint()
    private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
    private val bounds = RectF(150f.dp, 50f.dp, 300f.dp, 200f.dp)
    private val circleBitmap = Bitmap.createBitmap(150f.dp.toInt(), 150f.dp.toInt(), Bitmap.Config.ARGB_8888)
    private val squareBitmap = Bitmap.createBitmap(150f.dp.toInt(), 150f.dp.toInt(), Bitmap.Config.ARGB_8888)

    init {
        // 注意绘制绘制范围
        val canvas = Canvas(circleBitmap)
        paint.color = Color.parseColor("#D81B60")
        canvas.drawOval(50f.dp, 0f.dp, 150f.dp, 100f.dp, paint)
        canvas.setBitmap(squareBitmap)
        paint.color = Color.parseColor("#2196F3")
        canvas.drawRect(RectF(0f.dp, 50f.dp, 100f.dp, 150f.dp), paint)
    }

    override fun onDraw(canvas: Canvas) {
        var saveLayer = canvas.saveLayer(bounds, null)
        canvas.drawBitmap(circleBitmap, 150f.dp, 50f.dp, paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(squareBitmap, 150f.dp, 50f.dp, paint)
        paint.xfermode = null
        canvas.restoreToCount(saveLayer)
    }

}