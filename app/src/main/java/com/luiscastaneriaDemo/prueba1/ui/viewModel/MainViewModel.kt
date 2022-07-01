package com.luiscastaneriaDemo.prueba1.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.luiscastaneriaDemo.prueba1.core.Resource
import com.luiscastaneriaDemo.prueba1.data.Repo
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Callback
import retrofit2.http.Url
import java.lang.Exception

open class MainViewModel(private val repo: Repo) : ViewModel() {


    val fecthListPhone = liveData(Dispatchers.IO) {


        try {
            runBlocking {
                emit(repo.getPhoneList())
            }
        } catch (e: Exception) {
            runBlocking {
                Log.d("error", e.toString())
            }
        }


    }





}