package com.masai.cameraapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.cameraapp.R
import com.masai.cameraapp.data.MyEntity
import kotlinx.android.synthetic.main.image_item_layout.view.*

/**
 * This class is responsible for create and bind the data in the recyclerview
 */
class ImageAdapter(
    val context: Context,
    var imageList: List<MyEntity>,
) : RecyclerView.Adapter<ImageAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.apply {
          Glide.with(context).load(imageList[position].image).into(item_image)
        }

    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun setData(newData: List<MyEntity>) {
        imageList = newData
        notifyDataSetChanged()
    }
}