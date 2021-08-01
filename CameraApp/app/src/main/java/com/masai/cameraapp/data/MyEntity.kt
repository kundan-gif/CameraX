package com.masai.cameraapp.data

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * This is the structure of our table in the database
 */
@Entity(tableName = "my_image_table")
data class MyEntity(
    @ColumnInfo(name = "image") val image: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}