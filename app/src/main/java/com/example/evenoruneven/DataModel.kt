package com.example.evenoruneven

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel: ViewModel() {
    val  txtEvenCheckForPlayerFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val  txtUnevenCheckForPlayerFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    val  butStartClickFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


}