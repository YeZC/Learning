package com.example.learningmaterials.custom_view.layout

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.example.learningmaterials.custom_view.dp
import kotlin.math.min

class SquareImageView(context: Context?, attrs: AttributeSet?) :
    AppCompatImageView(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }


}