package com.example.basicgiphyapp.util.bindmethods

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageViewBindingAdapter {
    @BindingAdapter(value = ["android:src", "placeholder"], requireAll = false)
    @JvmStatic
    fun loadImage(
        view: ImageView,
        imageUri: Uri?,
        @DrawableRes placeholder: Int
    ) = view.apply {
        if (imageUri == null) {
            setImageResource(placeholder)
        } else {
            Glide.with(this).load(imageUri).placeholder(placeholder).into(this)
        }
    }

    @BindingAdapter(value = ["android:src", "placeholder"], requireAll = false)
    @JvmStatic
    fun loadImage(
        view: ImageView,
        imageUri: Uri?,
        placeholder: Drawable?
    ) = view.apply {
        if (imageUri == null) {
            setImageDrawable(placeholder)
        } else {
            Glide.with(this).load(imageUri).placeholder(placeholder).into(this)
        }
    }

    @BindingAdapter(value = ["android:src", "placeholder"], requireAll = false)
    @JvmStatic
    fun loadGif(
        view: ImageView,
        imageUri: Uri?,
        placeholder: Int,
    ) = view.apply {
        if (imageUri == null) {
            setImageResource(placeholder)
        } else {
            Glide.with(this).asGif().load(imageUri).into(this)
        }
    }

}