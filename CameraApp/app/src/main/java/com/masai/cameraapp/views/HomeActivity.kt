package com.masai.cameraapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.masai.cameraapp.R
import com.masai.cameraapp.adapter.ImageAdapter
import com.masai.cameraapp.data.MyEntity
import com.masai.cameraapp.interfaces.ItemClickListener
import com.masai.cameraapp.viewmodels.MyViewModel
import com.masai.cameraapp.viewmodels.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(),ItemClickListener {
    private lateinit var viewModel:MyViewModel
    private val entity= mutableListOf<MyEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setRecyclerView()
        btnOpenCamera.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun setRecyclerView() {
        val adapter2=ImageAdapter(this,entity,this)
        recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
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
    }

    override fun onItemClicked(myEntity: MyEntity) {
      val intent=Intent(this,ImagePreviewActivity::class.java)
        intent.putExtra("key",myEntity.image)
        startActivity(intent)
    }
}