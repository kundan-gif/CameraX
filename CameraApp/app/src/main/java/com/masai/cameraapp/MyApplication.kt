package com.masai.cameraapp

import android.app.Application
import com.masai.cameraapp.data.MyDatabase
import com.masai.cameraapp.repository.MyRepository


class MyApplication:Application() {
    private val myDao by lazy {
        val roomDatabase=MyDatabase.getDatabase(this)
        roomDatabase.getMyDao()
    }
    val repository:MyRepository by lazy {
        MyRepository(myDao)
    }
}