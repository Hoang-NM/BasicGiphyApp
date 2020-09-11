package com.example.basicgiphyapp.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Original(
    @SerializedName("height") @Expose val height: String,
    @SerializedName("width") @Expose val width: String,
    @SerializedName("size") @Expose val size: String,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("mp4_size") @Expose val mp4Size: String,
    @SerializedName("mp4") @Expose val mp4: String,
    @SerializedName("webp_size") @Expose val webpSize: String,
    @SerializedName("webp") @Expose val webp: String,
    @SerializedName("frame") @Expose val frame: String,
    @SerializedName("hash") @Expose val hash: String
) : Serializable