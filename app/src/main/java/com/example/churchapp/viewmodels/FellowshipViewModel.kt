package com.example.churchapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.churchapp.models.Fellowship
import com.example.churchapp.repositories.FellowshipRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class FellowshipViewModel : ViewModel() {
    val fellowshipRepository = FellowshipRepository()
    val response:LiveData<List<Fellowship>>
    val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        getFellowships()
        response = fellowshipRepository.response
    }
    fun getFellowships() {
        coroutineScope.launch {
            fellowshipRepository.getFellowships()
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}