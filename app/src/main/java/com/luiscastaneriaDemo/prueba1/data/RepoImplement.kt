package com.luiscastaneriaDemo.prueba1.data

import com.luiscastaneriaDemo.prueba1.core.Resource
import com.luiscastaneriaDemo.prueba1.model.PhoneListModel
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import retrofit2.Response
import retrofit2.http.Query
import retrofit2.http.Url

class RepoImplement(private val dataSource: DataSource): Repo {


    override suspend fun getPhoneList(): List<PhoneListModelItem>  {
        return  dataSource.getPhoneByName()
    }







}