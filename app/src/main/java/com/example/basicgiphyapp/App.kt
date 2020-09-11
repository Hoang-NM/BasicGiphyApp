package com.example.basicgiphyapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("Build Injector")
        /*return DaggerAppInjector.builder()
            .application(this)
            .build().also {
                it.inject(this)
            }*/
    }

    override fun onCreate() {
        super.onCreate()
        val basic = 1
    }

}
