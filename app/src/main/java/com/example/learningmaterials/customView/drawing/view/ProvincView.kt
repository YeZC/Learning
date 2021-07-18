package com.example.learningmaterials.customView.drawing.view

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.customView.drawing.dp

private val provinces = listOf<String>(
    "北京市",
    "天津市",
    "广州市",
    "新疆",
    "香港",
    "澳门"
)
class ProvincView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 80.dp
        textAlign = Paint.Align.CENTER
    }
    var province = "广州市"
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawText(province, width / 2f, height / 2f, paint)
    }
}

class ProvinceEvaluator : TypeEvaluator<String> {
    override fun evaluate(fraction: Float, startValue: String?, endValue: String?): String {
        val startIndex = provinces.indexOf(startValue)
        val endIndex = provinces.indexOf(endValue)
        val index = startIndex + (endIndex - startIndex) * fraction
        return provinces.get(index.toInt())
    }

}