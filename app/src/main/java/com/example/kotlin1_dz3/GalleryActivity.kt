package com.example.kotlin1_dz3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1_dz3.model.Images
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    private lateinit var imageAdapter: AdapterGallery

    private var imageList = listOf(
        Images(imageID = R.drawable.fayer),
        Images(imageID = R.drawable.nolik),
        Images(imageID = R.drawable.igrek),
        Images(imageID = R.drawable.shpulya),
        Images(imageID = R.drawable.rubble),
        Images(imageID = R.drawable.simka)
    )



    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        initRecycler()
    }

    private fun initRecycler() {

        rv_gallery_activity.apply {
            imageAdapter = AdapterGallery()
            adapter = imageAdapter
        }

        btn_add_image.setOnClickListener {
            if (index > 5) index = 0
            val imageModel = imageList[index]
            imageAdapter.addImageList(imageModel)
            index++
        }

        btn_sent_gallery_activity.setOnClickListener {
            val list = arrayListOf<Images>()
            for (model in imageAdapter.itemImages){
                if (model.selected){
                    list.add(model)
                }
            }
            val converter = CategoryConverter()
            val listFromStr = converter.fromListCategoryModel(list)
            
        }
    }
}