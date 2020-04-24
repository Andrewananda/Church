package com.example.churchapp.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.data.ApiService
import com.example.churchapp.models.Fellowship

enum class FellowshipApiStatus { FLOADING,FERROR,FDONE}

class FellowshipRepository {
    val fellowshipApi = ApiService

    //Get the api status
    val _status = MutableLiveData<FellowshipApiStatus>()
    val status:LiveData<FellowshipApiStatus>
    get() = _status

    val _response = MutableLiveData<List<Fellowship>>()
    val response:LiveData<List<Fellowship>>
    get() = _response

    suspend fun getFellowships() {
        val getDeferred = fellowshipApi.retrofitService.getFellowships()
        try {
            _status.value = FellowshipApiStatus.FLOADING
            val results = getDeferred.await()
            _status.value = FellowshipApiStatus.FDONE
            _response.value = results
        }catch (t:Throwable) {
            _status.value = FellowshipApiStatus.FERROR
            Log.e("FELLOWSHIP ERROR","${t.message}")
            _response.value = ArrayList()
        }
    }
}