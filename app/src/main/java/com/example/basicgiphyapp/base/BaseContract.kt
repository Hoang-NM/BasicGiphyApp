package com.example.basicgiphyapp.base

import android.content.res.Resources
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.lifecycle.LifecycleOwner

interface BaseContract {
    interface Scene {
        fun getSceneResources(): Resources?

        fun getSceneArguments(): Bundle?

        fun toast(message: String?)

        fun toast(@StringRes message: Int)

        fun requestSceneBackward()
    }

    interface ViewModel<SCENE : Scene> {
        fun isSceneAttached(): Boolean

        fun onAttachToScene(scene: SCENE)

        fun onAttachLifecycle(owner: LifecycleOwner)

        fun onViewModelCreated()

        fun onViewModelDestroy()

        fun onDetachLifecycle(owner: LifecycleOwner)

        fun onDetachFromScene()
    }
}