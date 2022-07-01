package com.luiscastaneriaDemo.prueba1.data

import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem

interface Repo {
     suspend fun getPhoneList(): List<PhoneListModelItem>


}