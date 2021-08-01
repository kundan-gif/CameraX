package com.masai.cameraapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.masai.cameraapp.data.MyEntity
import com.masai.cameraapp.repository.MyRepository


class MyViewModel(private val repository: MyRepository):ViewModel() {

    fun addImages(myEntity: MyEntity){
        repository.addImages(myEntity)
    }
    fun getImages():LiveData<List<MyEntity>> {
        return repository.getImages()
    }

}