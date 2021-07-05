package com.example.kotlin1_dz3

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin1_dz3.model.Images
import kotlinx.android.synthetic.main.item_images.view.*
import kotlin.collections.ArrayList

class AdapterGallery(

//    private var listener: ImageListener

) : RecyclerView.Adapter<AdapterGallery.GalleryVH>() {



    public val itemImages = ArrayList<Images>()

    private var selectedImagesList = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryVH {
        val view =  LayoutInflater.from(parent.context)
            .inflate(R.layout.item_images, parent, false)
        return GalleryVH(view)
    }

    override fun onBindViewHolder(holder: GalleryVH, position: Int) {

        holder.bind(itemImages[position])

    }

    override fun getItemCount(): Int {
       return itemImages.size
    }

    fun addImageList(images: Images){
        itemImages.add(images)
        notifyDataSetChanged()
    }

    inner class GalleryVH (itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var image: ImageView = itemView.iv_item_image
        private var transImage: View = itemView.trans_view

        @SuppressLint("ResourceAsColor")
        fun bind(images: Images){

           image.setOnLongClickListener {

               images.selected = !images.selected
               if (images.selected){
                    transImage.setBackgroundColor(R.color.trans_black)
                    notifyDataSetChanged()
               } else {
                   transImage.setBackgroundColor(Color.TRANSPARENT)
               }
               true
           }
            Glide.with(itemView.context)
                .load(images.imageID)
                .into(image)
        }
    }

    interface ImageListener {
        fun itemLongClick(images: Images)
    }
}