package com.example.dagger2retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger2retrofit.model.Data
import com.example.dagger2retrofit.model.NetWorkModel
import com.example.dagger2retrofit.model.UserRepository
import dagger.Component
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: UserRepository):ViewModel(){
private val _allItems= MutableLiveData<List<Data>>()
var allItems:LiveData<List<Data>> =_allItems
    init {
        allItems=repository.allItems
    }

}

@Component(modules = arrayOf(NetWorkModel::class))
interface ComponentInterface{
    fun getViewModel():MainViewModel
    fun getRepository():UserRepository
}