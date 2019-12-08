package com.example.dagger2retrofit.model

import javax.inject.Inject

class UserRepository @Inject constructor(private val networkApi: NetworkApi){
val allItems=networkApi.loadAllItems()

}