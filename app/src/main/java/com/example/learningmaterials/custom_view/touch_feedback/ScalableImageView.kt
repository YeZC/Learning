package com.example.learningmaterials.custom_view.touch_feedback

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.OverScroller
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.ViewCompat
import com.example.learningmaterials.R
import com.example.learningmaterials.custom_view.dp
import kotlin.math.max
import kotlin.math.min

private val IMAGE_SIZE = 300.dp.toInt()
private const val EXTRA_SCALE_FRACTOR = 1.5f
class ScalableImageView(context: Context?, attrs: AttributeSet?)
    : View(context, attrs), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, Runnable{

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(IMAGE_SIZE)
    private var originOffsetX = 0f
    private var originOffsetY = 0f
    private var smallScale = 0f
    private var bigScale = 0f
    private val gestureDetectorCompat = GestureDetectorCompat(context, this)
    private var big = false
    private var scaleFraction = 0f
        set(value) {
            field = value
            invalidate()
        }
    private val scaleAnimation : ObjectAnimator by lazy {
        ObjectAnimator.ofFloat(this, "scaleFraction", 0f, 1f)
    }
    private var offsetX = 0f
    private var offsetY = 0f
    private var scroller = OverScroller(context)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        originOffsetX = (width - IMAGE_SIZE) / 2f
        originOffsetY = (height - IMAGE_SIZE) / 2f

        if(bitmap.width / bitmap.height.toFloat() > width / height.toFloat()){
            smallScale = width / bitmap.width.toFloat()
            bigScale = height / bitmap.height.toFloat() * EXTRA_SCALE_FRACTOR
        }else{
            smallScale = height / bitmap.height.toFloat()
            bigScale = width / bitmap.width.toFloat() * EXTRA_SCALE_FRACTOR
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.translate(offsetX, offsetY)
        val scale = smallScale + (bigScale - smallScale) * scaleFraction
        canvas.scale(scale, scale, width / 2f, height / 2f)
        canvas.drawBitmap(bitmap, originOffsetX, originOffsetY, paint)
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

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetectorCompat.onTouchEvent(event)
    }

    override fun onShowPress(e: MotionEvent?) {
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onFling(
        downEvent: MotionEvent?,
        currentEvent: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if(big){
            scroller.fling(
                offsetX.toInt(), offsetY.toInt(), velocityX.toInt(), velocityY.toInt(),
                (- (bitmap.width * bigScale - width) / 2).toInt(),
                ((bitmap.width * bigScale - width) / 2).toInt(),
                (- (bitmap.height * bigScale - height) / 2).toInt(),
                ((bitmap.height * bigScale - height) / 2).toInt(),
                40.dp.toInt(),
                40.dp.toInt()
            )
            ViewCompat.postOnAnimation(this, this)
        }
        return false
    }

    override fun run() {
        if (scroller.computeScrollOffset()) {
            offsetX = scroller.currX.toFloat()
            offsetY = scroller.currY.toFloat()
            invalidate()
            ViewCompat.postOnAnimation(this, this)
        }
    }

    override fun onScroll(
        downEvent: MotionEvent?,
        currentEvent: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        if(big){
            offsetX -= distanceX
            offsetX = min(offsetX, (bitmap.width * bigScale - width) / 2)
            offsetX = max(offsetX, - (bitmap.width * bigScale - width) / 2)
            offsetY -= distanceY
            offsetY = min(offsetY, (bitmap.height * bigScale - height) / 2)
            offsetY = max(offsetY, - (bitmap.height * bigScale - height) / 2)
            invalidate()
        }
        return false
    }



    override fun onLongPress(e: MotionEvent?) {
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        big = !big
        if(big){
            scaleAnimation.start()
        }else{
            scaleAnimation.reverse()
        }
        offsetX = 0f
        offsetY = 0f
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        return false
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        return false
    }
}