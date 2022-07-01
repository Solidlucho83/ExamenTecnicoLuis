package com.luiscastaneriaDemo.prueba1.data

import com.luiscastaneriaDemo.prueba1.core.Resource
import com.luiscastaneriaDemo.prueba1.core.RetrofitClient
import com.luiscastaneriaDemo.prueba1.model.PhoneListModel
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import retrofit2.Response
import retrofit2.http.Query
import javax.security.auth.callback.Callback

class DataSource {

    suspend fun getPhoneByName(): List<PhoneListModelItem> {
        return RetrofitClient.webService.getPhoneByName()
    }



}