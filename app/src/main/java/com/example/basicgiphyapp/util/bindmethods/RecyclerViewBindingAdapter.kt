package com.example.basicgiphyapp.util.bindmethods

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object RecyclerViewBindingAdapter {
    @BindingAdapter("rvAdapter")
    @JvmStatic
    fun setRecyclerViewAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<*>?
    ) {
        recyclerView.adapter = adapter
    }
}