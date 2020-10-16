package com.example.basicgiphyapp.ui.main.contract

import com.example.basicgiphyapp.base.BaseContract

interface MainContract {
    interface Scene : BaseContract.Scene

    interface ViewModel : BaseContract.ViewModel<Scene>
}