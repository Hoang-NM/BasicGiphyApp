package com.example.basicgiphyapp.util.helper

import android.content.Context
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

object RecyclerViewLayoutManagerHelper {

    @JvmStatic
    fun flexBox(context: Context) = FlexboxLayoutManager(context).apply {
        flexDirection = FlexDirection.ROW
        justifyContent = JustifyContent.FLEX_START
        alignItems = AlignItems.CENTER
    }
}