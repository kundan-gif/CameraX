package com.masai.cameraapp.repository

import androidx.lifecycle.LiveData
import com.masai.cameraapp.data.MyDao
import com.masai.cameraapp.data.MyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(private val myDao: MyDao) {

  fun addImages(myEntity: MyEntity){
      CoroutineScope(Dispatchers.IO).launch {
          myDao.insertImages(myEntity)
      }

  }
    fun getImages():LiveData<List<MyEntity>> {
        return myDao.getImages()
    }
}