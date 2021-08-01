package com.example.learningmaterials.custom_view.drawing.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.learningmaterials.R
import com.example.learningmaterials.custom_view.dp

class AvatarView(context: Context?, attrs: AttributeSet?) :
        View(context, attrs) {

    private val paint = Paint()
    private val IMAGE_WIDTH = 200f.dp
    private val IMAGE_PADDING = 20f.dp
    private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private val bounds = RectF(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING + IMAGE_WIDTH, IMAGE_PADDING + IMAGE_WIDTH)

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds, null)
        canvas.drawOval(bounds, paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), IMAGE_PADDING, IMAGE_PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
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