package com.masai.cameraapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {

    /**
     * This function will insert all the items in the Database
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertImages(myEntity: MyEntity)

    /**
     * This function will return all the items from the Database
     */
    @Query("select * from my_image_table ")
    fun getImages(): LiveData<List<MyEntity>>

}