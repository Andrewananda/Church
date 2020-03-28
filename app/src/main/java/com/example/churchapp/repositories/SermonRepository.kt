package com.example.churchapp.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.data.ApiService
import com.example.churchapp.models.Sermon
enum class SermonApiStatus{LOADING,ERROR,DONE}

class SermonRepository {
    //check on status to display data
    val _status = MutableLiveData<SermonApiStatus>()
    val status:LiveData<SermonApiStatus>
    get() = _status

    //get APi response
    val sermonApi = ApiService
    val _response = MutableLiveData<List<Sermon>>()
    val response:LiveData<List<Sermon>>
    get() = _response

   suspend fun getSermons(){
        val getDeferred = sermonApi.retrofitService.getSermons()
        try {
            _status.value = SermonApiStatus.LOADING
            val results = getDeferred.await()

            _status.value = SermonApiStatus.DONE
            _response.value = results

        }catch (t:Throwable){
            _status.value = SermonApiStatus.ERROR
            _response.value = ArrayList()
        }

    }
}