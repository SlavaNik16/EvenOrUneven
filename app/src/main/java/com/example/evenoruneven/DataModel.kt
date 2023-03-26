package com.example.evenoruneven

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel: ViewModel() {
    val  CountForPlayerFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val  txtListForPlayerFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val  txtSumForPlayerFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val  txtEvenCheckForPlayerFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val  txtUnevenCheckForPlayerFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val  imageEvenForPlayerFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val  imageUnevenForPlayerFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }



    val  CountForCompFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val  txtListForCompFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val  txtSumForCompFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val  txtEvenCheckForCompFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val  txtUnevenCheckForCompFragment: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val  imageEvenForCompFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val  imageUnevenForCompFragment: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}