package com.example.churchapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.churchapp.models.Sermon
import com.example.churchapp.repositories.ApiStatus
import com.example.churchapp.repositories.SermonRepository
import kotlinx.coroutines.*

class Sermonviewmodel : ViewModel() {
   private val sermonRepository:SermonRepository = SermonRepository()
    val response:LiveData<List<Sermon>>
    val status:LiveData<ApiStatus>
    //navigation
    private val _navigateToSelectedSermon = MutableLiveData<Sermon>()
    val navigateToSelectedSermon:LiveData<Sermon>
        get() = _navigateToSelectedSermon

    val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        getSermons()
        response = sermonRepository.response
        status = sermonRepository.status
    }

    private fun getSermons() {
        coroutineScope.launch {
            sermonRepository.getSermons()
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }

    fun displaySelectedSermon(selectedSermon:Sermon){
        _navigateToSelectedSermon.value = selectedSermon
    }
    fun displaySelectedSermonComplete(){
        _navigateToSelectedSermon.value = null
    }
}