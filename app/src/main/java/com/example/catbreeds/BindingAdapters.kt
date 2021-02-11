package com.example.catbreeds

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.catbreeds.list.ItemGridAdapter
import com.example.catbreeds.network.BreedProperty

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("breedHeader")
fun bindHeader(textView: TextView, breedName: String?) {
    breedName?.let {
        textView.text = breedName
    }
}

@BindingAdapter("breedDescription")
fun bindDescription(textView: TextView, breedDescription: String?){
    breedDescription?.let {
        textView.text = breedDescription
    }
}

@BindingAdapter("breedTemperament")
fun bindTemperament(textView: TextView, breedTemperament: String?){
    breedTemperament?.let {
        textView.text = breedTemperament
    }
}

@BindingAdapter("breedLifespan")
fun bindLifeSpan(textView: TextView, breedLifespan: String?){
    breedLifespan?.let {
        textView.text = breedLifespan
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<BreedProperty>?) {
    val adapter = recyclerView.adapter as ItemGridAdapter
    adapter.submitList(data)
}