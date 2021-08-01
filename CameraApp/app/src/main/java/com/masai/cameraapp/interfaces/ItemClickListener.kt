package com.masai.cameraapp.interfaces

import com.masai.cameraapp.data.MyEntity


interface ItemClickListener {
    fun onItemClicked(myEntity: MyEntity)
}