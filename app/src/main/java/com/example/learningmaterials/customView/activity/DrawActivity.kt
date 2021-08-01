package com.example.learningmaterials.customView.activity

import android.animation.*
import android.graphics.PointF
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningmaterials.R
import com.example.learningmaterials.customView.drawing.dp
import com.example.learningmaterials.customView.drawing.view.ProvinceEvaluator
import kotlinx.android.synthetic.main.activity_custom_view.*

class DrawActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 图形的位置和尺寸测量
        // Xfermode
        // 文字测量
        // 范围裁切和几何变换
        setContentView(R.layout.activity_custom_view)

        // 属性动画和硬件加速
//        v_view.animate()
//            .translationX(200.dp)
//            .translationY(100.dp)
//            .alpha(0.5f)
//            .scaleX(2f)
//            .scaleY(2f)
//            .startDelay = 1_000



//        val animator = ObjectAnimator
//            .ofFloat(v_circle_view, "radius", 150.dp)
//        animator.startDelay = 1_000
//        animator.start()




//        val bottomFlipAnimator = ObjectAnimator
//            .ofFloat(v_camera_view, "bottomFlip", 60f)
//        bottomFlipAnimator.startDelay = 1_000
//
//        val flipRotationFlipAnimator = ObjectAnimator
//            .ofFloat(v_camera_view, "flipRotation", 270f)
//        flipRotationFlipAnimator.startDelay = 200
//        flipRotationFlipAnimator.duration = 1_000
//
//        val topFlipAnimator = ObjectAnimator
//            .ofFloat(v_camera_view, "topFlip", - 60f)
//        topFlipAnimator.startDelay = 200
//        topFlipAnimator.duration = 1_000
//
//        val animatorSet = AnimatorSet()
//        animatorSet.playSequentially(bottomFlipAnimator, flipRotationFlipAnimator, topFlipAnimator)
//        animatorSet.apply {
//            start()
//        }

//        val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
//        val flipRationFlipHolder = PropertyValuesHolder.ofFloat("flipRotation", 270f)
//        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
//        val holderAnimator = ObjectAnimator
//            .ofPropertyValuesHolder(v_camera_view, bottomFlipHolder, flipRationFlipHolder, topFlipHolder)
//        holderAnimator.apply {
//            startDelay = 1_000
//            duration = 2_000
//            start()
//        }

//        val length = 200.dp
//        val keyFrame1 = Keyframe.ofFloat(0f, 0f)
//        val keyFrame2 = Keyframe.ofFloat(0.2f, 1.5f * length)
//        val keyFrame3 = Keyframe.ofFloat(0.8f, 0.6f * length)
//        val keyFrame4 = Keyframe.ofFloat(1f, 1f * length)
//        val keyFrameHolder = PropertyValuesHolder
//            .ofKeyframe("translationX", keyFrame1, keyFrame2, keyFrame3, keyFrame4)
//        val animator = ObjectAnimator.ofPropertyValuesHolder(v_view, keyFrameHolder)
//        animator.apply {
//            startDelay = 1_000
//            duration = 2_000
//            start()
//        }



//        val animator = ObjectAnimator.ofFloat()
//        animator.interpolator = AccelerateDecelerateInterpolator()



//        val animator = ObjectAnimator.ofObject(v_point_view,
//            "point", PointFEvaluator(), PointF(100.dp, 200.dp))
//        animator.apply {
//            startDelay = 1_000
//            duration = 2_000
//            start()
//        }



//        val animator = ObjectAnimator.ofObject(v_province_view,
//            "province", ProvinceEvaluator(), "澳门")
//        animator.apply {
//            startDelay = 1_000
//            duration = 4_000
//            start()
//        }
    }

    class PointFEvaluator : TypeEvaluator<PointF> {
        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            val startX = startValue.x
            val endX = endValue.y
            val currentX = startX + (endX - startX) * fraction

            val startY = startValue.x
            val endY = endValue.y
            val currentY = startY + (endY - startY) * fraction

            return PointF(currentX, currentY)
        }

    }
}