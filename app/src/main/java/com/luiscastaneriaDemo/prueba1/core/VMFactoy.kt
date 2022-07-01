package com.luiscastaneriaDemo.prueba1.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luiscastaneriaDemo.prueba1.data.Repo

class VMFactoy(private  val repo: Repo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }

}