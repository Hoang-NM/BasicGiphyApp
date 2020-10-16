package com.example.basicgiphyapp.util.module

import android.content.Context
import com.example.basicgiphyapp.base.BaseApplication
import com.example.basicgiphyapp.data.apiservice.ClientService
import com.example.basicgiphyapp.data.const.Define
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

object Retrofits {
    private fun defaultOkHttpClient(vararg interceptors: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            this.interceptors().addAll(interceptors)
            BaseApplication.getInstance().let { it ->
                HttpLoggingInterceptor().apply {
                    level = if (it.isDebugMode()) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                }.also { this.interceptors().add(it) }
                Cache(it.cacheDir, 10 * 1024 * 1024).also {
                    this.cache(it)
                }
            }
            readTimeout(30, TimeUnit.SECONDS)
            connectTimeout(30, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }.build()
    }

    fun newClient(domain: String, gson: Gson, vararg interceptors: Interceptor): Retrofit {
        return Retrofit.Builder()
            .baseUrl(domain)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(defaultOkHttpClient(*interceptors))
            .build()
    }
}

@Module
class RestfulApiModule {

    @Singleton
    @Provides
    fun provideClientService(
        context: Context,
        gson: Gson
    ): ClientService =
        Retrofits.newClient(
            Define.BASE_URL,
            gson
        ).create()
}