package com.example.basicgiphyapp.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Images(
    @SerializedName("original") @Expose val original: Original
) : Serializable