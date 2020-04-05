package com.example.churchapp.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.data.ApiService
import com.example.churchapp.models.Event
import java.util.ArrayList

class EventRepository {
    val apiService = ApiService
    val _response = MutableLiveData<List<Event>>()
    val response:LiveData<List<Event>>
    get() = _response

    suspend fun getEvents() {
        val getDeferred = apiService.retrofitService.getEvents()
        try {
            val result =  getDeferred.await()
            _response.value = result

        }catch (t:Throwable) {
            _response.value = ArrayList()
        }
    }
}