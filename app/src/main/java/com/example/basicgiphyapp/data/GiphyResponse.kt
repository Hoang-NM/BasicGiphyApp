package com.example.basicgiphyapp.data

import com.example.basicgiphyapp.data.pojo.Data
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class GiphyResponse(
    @SerializedName("data") @Expose val dataList: List<Data>
)