package com.example.learningmaterials.customView.drawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.example.learningmaterials.R
import com.example.learningmaterials.customView.drawing.dp

private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp
class CameraView2(context: Context?, attrs: AttributeSet?) :
        View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
    private val camera = Camera()

    var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    var bottomFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        //
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        // 斜切
        canvas.withSave {
            canvas.save()
            canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(topFlip)
            camera.applyToCanvas(canvas)
            camera.restore()
            canvas.clipRect(- BITMAP_SIZE, - BITMAP_SIZE, BITMAP_SIZE, 0f)
            canvas.rotate(flipRotation)
            canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), - (BITMAP_PADDING + BITMAP_SIZE / 2))
            canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        }

        canvas.withSave {
            canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2f, BITMAP_PADDING + BITMAP_SIZE / 2f)
            canvas.rotate(-flipRotation)
            camera.save()
            camera.rotateX(bottomFlip)
            camera.applyToCanvas(canvas)
            camera.restore()
            canvas.clipRect( - BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
            canvas.rotate(flipRotation)
            canvas.translate(- (BITMAP_PADDING + BITMAP_SIZE / 2f), - (BITMAP_PADDING + BITMAP_SIZE / 2f))
            canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        }
    }

    fun getAvatar(width: Int): Bitmap{
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