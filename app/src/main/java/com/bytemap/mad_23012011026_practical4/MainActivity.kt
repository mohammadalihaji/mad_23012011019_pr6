package com.bytemap.mad_23012011026_practical4

import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var alarmImage: ImageView
    private lateinit var frameAnimation: AnimationDrawable
    private lateinit var heartIcon: ImageView
    private lateinit var heartAnimation: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        alarmImage = findViewById(R.id.alarmImage)
        heartIcon = findViewById(R.id.heartIcon)

        alarmImage.setBackgroundResource(R.drawable.alarm_animation_list)
        frameAnimation = alarmImage.background as AnimationDrawable

        heartIcon.setBackgroundResource(R.drawable.heart_animation_list)
        heartAnimation = heartIcon.background as AnimationDrawable

            if (!frameAnimation.isRunning) {
                frameAnimation.start()
                heartAnimation.start()
            }
    }
}