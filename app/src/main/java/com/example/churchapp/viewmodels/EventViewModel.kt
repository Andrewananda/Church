package com.example.churchapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.churchapp.models.Event
import com.example.churchapp.repositories.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {
    val eventRepository:EventRepository = EventRepository()
    val response: LiveData<List<Event>>

    val job = Job()
    val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    init {
        getEvents()
        response = eventRepository.response
    }

    private fun getEvents() {
        coroutineScope.launch {
            eventRepository.getEvents()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}