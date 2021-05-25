package com.lire.restful

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BgmDataViewModelFactory(val arg : BgmRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(BgmRepository::class.java).newInstance(arg)
    }
}