package com.masai.cameraapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.masai.cameraapp.R
import kotlinx.android.synthetic.main.activity_pre_view.*


class PreViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_view)
        if (intent.extras != null) {
            val image = intent.getStringExtra("imageKey")
            Glide.with(this).load(image).into(photo_view_pager)
            back_button.setOnClickListener {
                onBackPressed()
            }
        }

    }


}