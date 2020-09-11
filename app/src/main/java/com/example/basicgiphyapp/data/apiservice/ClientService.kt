package com.example.basicgiphyapp.data.apiservice

import com.example.basicgiphyapp.data.GiphyResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientService {
    @GET("/gifs/trending")
    fun getTrendingGifs(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int,
        @Query("rating") rating: String
    ): Single<GiphyResponse>

    @GET("/stickers/trending")
    fun getTrendingStickers(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int,
        @Query("rating") rating: String
    ): Single<GiphyResponse>
}