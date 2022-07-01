package com.luiscastaneriaDemo.prueba1.data

import com.luiscastaneriaDemo.prueba1.core.Resource
import com.luiscastaneriaDemo.prueba1.model.PhoneListModel
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import com.luiscastaneriaDemo.prueba1.model.deviceModel
import retrofit2.Response
import retrofit2.http.*

interface WebService {
    @Headers("Accept: application/json")
    @GET("devices")
    suspend fun getPhoneByName(): List<PhoneListModelItem>

    @GET
    suspend fun getPhoneDetail(@Url url: String): deviceModel




}