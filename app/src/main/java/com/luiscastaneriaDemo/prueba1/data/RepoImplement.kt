package com.luiscastaneriaDemo.prueba1.data

import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem

class RepoImplement(private val dataSource: DataSource): Repo {


    override suspend fun getPhoneList(): List<PhoneListModelItem>  {
        return  dataSource.getPhoneByName()
    }







}