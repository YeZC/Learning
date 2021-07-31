package com.example.learningmaterials.customView.drawing.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.example.learningmaterials.R
import com.example.learningmaterials.customView.drawing.dp

private val TEXT_SIZE = 12.dp
private val TEXT_MARGIN = 8.dp
private val HORIZONTAL_OFFSET = 5.dp
private val VERTICAL_OFFSET = 23.dp
private val EXTRA_VERTICAL_OFFSET = 16.dp
class MeterialEditText(context: Context, attrs: AttributeSet) :
    AppCompatEditText(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var floatingLabelShown = false
    private var floatingLabelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }
    private val animator by lazy {
        ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0f, 1f)
    }
    var useFloatingLabel = false
        set(value) {
            if(field != value){
                field = value
                if(field){
                    setPadding(paddingLeft, (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight, paddingBottom)
                }else{
                    setPadding(paddingLeft, (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(), paddingRight, paddingBottom)
                }
            }
        }

    init {
        paint.textSize = TEXT_SIZE

        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.MeterialEditText)
        useFloatingLabel = typeArray.getBoolean(R.styleable.MeterialEditText_useFloatingLabel, true)
        typeArray.recycle()
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        if(useFloatingLabel && floatingLabelShown && text.isNullOrEmpty()){
            floatingLabelShown = false
            animator.reverse()
        }else if(useFloatingLabel && !floatingLabelShown && !text.isNullOrEmpty()){
            floatingLabelShown = true
            animator.start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.alpha = (floatingLabelFraction * 0xff).toInt()
        val currentVerticalValue = VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction)
        canvas.drawText(hint as String, HORIZONTAL_OFFSET, currentVerticalValue, paint)
    }
}