package com.example.learningmaterials.custom_view.drawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.R
import com.example.learningmaterials.custom_view.dp

private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp
class CameraView(context: Context?, attrs: AttributeSet?) :
        View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
//    private val clip = Path().apply {
//        addOval(BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING + BITMAP_SIZE, BITMAP_PADDING + BITMAP_SIZE, Path.Direction.CCW)
//    }
    private val camera = Camera()

    init {
        //
        camera.rotateX(30f)
        val a = (BITMAP_PADDING + BITMAP_SIZE / 2f) / 72f
        // 翻转
//        camera.setLocation(0f, -0f, -12f)
        // 斜切
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
//        canvas.clipPath(clip)

        // 翻转
//        canvas.save()
//        canvas.clipRect(BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING + BITMAP_SIZE, BITMAP_PADDING + BITMAP_SIZE / 2f)
//        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
//        canvas.restore()
//
//        canvas.save()
//        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2f, BITMAP_PADDING + BITMAP_SIZE / 2f)
//        camera.applyToCanvas(canvas)
//        canvas.clipRect( - BITMAP_SIZE / 2f, 0f, BITMAP_SIZE / 2f, BITMAP_SIZE / 2f)
//        canvas.translate(- (BITMAP_PADDING + BITMAP_SIZE / 2f), - (BITMAP_PADDING + BITMAP_SIZE / 2f))
//        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
//        canvas.restore()

        // 斜切
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        canvas.clipRect(- BITMAP_SIZE, - BITMAP_SIZE, BITMAP_SIZE, 0f)
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), - (BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2f, BITMAP_PADDING + BITMAP_SIZE / 2f)
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect( - BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
        canvas.rotate(30f)
        canvas.translate(- (BITMAP_PADDING + BITMAP_SIZE / 2f), - (BITMAP_PADDING + BITMAP_SIZE / 2f))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()
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