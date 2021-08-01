package com.example.learningmaterials.custom_view.drawing.view

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.R
import com.example.learningmaterials.custom_view.dp

private val IMAGE_SIZE = 150.dp
private val IMAGE_PADDING = 50.dp
class MultilineTextView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {

    val text =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris porttitor, purus blandit dapibus ornare, arcu urna ultrices sem, et egestas risus ante non sem. Mauris scelerisque urna eget scelerisque rhoncus. Donec non velit sollicitudin, porttitor mi ac, elementum turpis. In pharetra iaculis felis, a pretium elit aliquet in. Aenean elementum porttitor massa, a suscipit dui commodo a. Cras sit amet facilisis elit. Sed id placerat metus.In pharetra iaculis felis, a pretium elit aliquet in. Aenean elementum porttitor massa, a suscipit dui commodo a. Cras sit amet facilisis elit. Sed id placerat metus."

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }
    private val bitmap = getAvatar(150.dp.toInt())
    private val fontMetrics = Paint.FontMetrics()

    override fun onDraw(canvas: Canvas) {
//        val staticLayout = StaticLayout(text, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, false)
//        staticLayout.draw(canvas)
        canvas.drawBitmap(bitmap, width - IMAGE_SIZE, 50.dp, paint)
        paint.getFontMetrics(fontMetrics)
        val measureWidth = floatArrayOf(0f)
        var start = 0
        var count: Int
        var verticalOffset = - fontMetrics.top
        var maxWidth: Float
        while (start < text.length){
            if(verticalOffset + fontMetrics.bottom < IMAGE_PADDING ||
                    verticalOffset + fontMetrics.top > IMAGE_PADDING + IMAGE_SIZE){
                maxWidth = width.toFloat()
            }else maxWidth = width.toFloat() - IMAGE_SIZE - 4.dp
            count = paint.breakText(text, start, text.length, true, maxWidth, measureWidth)
            canvas.drawText(text, start, start + count, 0f, verticalOffset, paint)
            start += count
            verticalOffset += paint.fontSpacing
        }

    }

    fun getAvatar(width: Int): Bitmap {
        var options = BitmapFactory.Options()
        options.apply {
            inJustDecodeBounds = true
            BitmapFactory.decodeResource(resources, R.drawable.ic_avatar, this)
            inJustDecodeBounds = false
            inDensity = outWidth
            inTargetDensity = width
        }
        return BitmapFactory.decodeResource(resources, R.drawable.ic_avatar, options)
    }

}