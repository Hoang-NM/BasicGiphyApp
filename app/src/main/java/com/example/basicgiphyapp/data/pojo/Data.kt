package com.example.basicgiphyapp.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("type") @Expose val type: String,
    @SerializedName("id") @Expose val id: String,
    @SerializedName("username") @Expose val username: String,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("rating") @Expose val rating: String,
    @SerializedName("is_sticker") @Expose val isSticker: Int,
    @SerializedName("images") @Expose val images: Images
)