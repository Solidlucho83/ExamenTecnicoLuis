package com.luiscastaneriaDemo.prueba1.data

import com.luiscastaneriaDemo.prueba1.core.Resource
import com.luiscastaneriaDemo.prueba1.model.PhoneListModel
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Repo {
     suspend fun getPhoneList(): List<PhoneListModelItem>


}