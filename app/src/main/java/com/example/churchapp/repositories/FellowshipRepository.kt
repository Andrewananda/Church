package com.example.churchapp.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.data.ApiService
import com.example.churchapp.models.Fellowship

class FellowshipRepository {
    val fellowshipApi = ApiService
    val _response = MutableLiveData<List<Fellowship>>()
    val response:LiveData<List<Fellowship>>
    get() = _response

    suspend fun getFellowships() {
        val getDeferred = fellowshipApi.retrofitService.getFellowships()
        try {
            val results = getDeferred.await()
            _response.value = results
        }catch (t:Throwable) {
            _response.value = ArrayList()
        }
    }
}