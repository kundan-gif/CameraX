package com.masai.cameraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.masai.cameraapp.adapter.ImageAdapter
import com.masai.cameraapp.data.MyEntity
import com.masai.cameraapp.viewmodels.MyViewModel
import com.masai.cameraapp.viewmodels.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var viewModel:MyViewModel
    val entity= mutableListOf<MyEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val adapter2=ImageAdapter(this,entity)
        recyclerView.layoutManager=GridLayoutManager(this,2)
        recyclerView.adapter=adapter2

        val appObj=application as MyApplication
        val repository=appObj.repository
        val viewModelFactory=MyViewModelFactory(repository)
        viewModel= ViewModelProviders.of(this,viewModelFactory)
            .get(MyViewModel::class.java)

        viewModel.getImages().observe(this, Observer {
            entity.clear()
            entity.addAll(it)
            adapter2.notifyDataSetChanged()
        })
        btnOpenCamera.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}