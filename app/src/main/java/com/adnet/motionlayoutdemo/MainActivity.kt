package com.adnet.motionlayoutdemo

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.motion_end.*

class MainActivity : AppCompatActivity(), MotionLayout.TransitionListener, View.OnTouchListener {
    var dX = 0f
    var dY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_start)
        motionLayout.setTransitionListener(this)
        textViewHienOc.setOnTouchListener(this)
    }

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
        //TODO("Not yet implemented")
    }

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
        //TODO("Not yet implemented")
    }

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
        //TODO("Not yet implemented")
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
        doBounceAnimation(textViewHello)
    }

    private fun doBounceAnimation(targetView: View) {
        val animator = ObjectAnimator.ofFloat(targetView, "translationY", 0f, -10f, 0f)
        animator.interpolator = BounceInterpolator()
        animator.duration = 1000
        animator.start()
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                view.animate()
                    .x(event.rawX + dX - (view.width / 2))
                    .y(event.rawY + dY - (view.height / 2))
                    .setDuration(0)
                    .start()
            }

            MotionEvent.ACTION_DOWN -> {
                dX = view.x - event.rawX
                dY = view.y - event.rawY
            }
        }

        return true
    }
}
