package com.bytemap.mad_23012011026_practical4

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var GUNI_LOGO : ImageView
    lateinit var anim_grow_spin : Animation
    lateinit var GUNI_FRAME_ANIMATION : AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        GUNI_LOGO = findViewById(R.id.image)
        GUNI_LOGO.setBackgroundResource(R.drawable.uvpce_animation_list)
        GUNI_FRAME_ANIMATION = GUNI_LOGO.background as AnimationDrawable

        anim_grow_spin = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        anim_grow_spin.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            GUNI_FRAME_ANIMATION.start()
            GUNI_LOGO.startAnimation(anim_grow_spin)
        } else {
            GUNI_FRAME_ANIMATION.stop()
        }
    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also {startActivity(it) }
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }

    override fun onAnimationStart(p0: Animation?) {
    }

}