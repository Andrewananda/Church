package com.example.churchapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.models.Event


class DetailEventViewModel(selected: Event,app:Application) : AndroidViewModel(app) {
    private val _selectedEvent = MutableLiveData<Event>()
    val selectedEvent:LiveData<Event>
    get() = _selectedEvent

    init {
        _selectedEvent.value = selected
    }

}
