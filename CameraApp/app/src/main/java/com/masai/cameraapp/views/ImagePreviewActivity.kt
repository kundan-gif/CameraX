package com.masai.cameraapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.masai.cameraapp.R
import kotlinx.android.synthetic.main.activity_image_preview.*
import kotlinx.android.synthetic.main.activity_pre_view.*

class ImagePreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview)
        if (intent.extras != null) {
            val image = intent.getStringExtra("key")
            Glide.with(this).load(image).into(preview_image)
            back_button_image.setOnClickListener {
                onBackPressed()
            }
        }
    }
}