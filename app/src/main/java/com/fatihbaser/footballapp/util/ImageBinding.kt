package com.fatihbaser.footballapp.util

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("android:imageUrl")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}