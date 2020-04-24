package com.example.churchapp.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.data.ApiService
import com.example.churchapp.models.Event
import java.util.ArrayList

enum class EventApiStatus{ELOADING,EERROR,EDONE}

class EventRepository {
    val apiService = ApiService
    val _status =  MutableLiveData<EventApiStatus>()
    val status:LiveData<EventApiStatus>
    get() = _status
    val _response = MutableLiveData<List<Event>>()
    val response:LiveData<List<Event>>
    get() = _response

    suspend fun getEvents() {
        val getDeferred = apiService.retrofitService.getEvents()
        try {
            _status.value = EventApiStatus.ELOADING
            val result =  getDeferred.await()
            _status.value = EventApiStatus.EDONE
            Log.i("EventRepository","Data available")
            _response.value = result

        }catch (t:Throwable) {
            _status.value = EventApiStatus.EERROR
            Log.e("EventRepository","An error Occurred")
            _response.value = ArrayList()
        }
    }
}