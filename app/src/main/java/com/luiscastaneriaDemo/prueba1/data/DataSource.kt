package com.luiscastaneriaDemo.prueba1.data

import com.luiscastaneriaDemo.prueba1.core.RetrofitClient
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem

class DataSource {

    suspend fun getPhoneByName(): List<PhoneListModelItem> {
        return RetrofitClient.webService.getPhoneByName()
    }



}