package com.example.churchapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.models.Fellowship

class DetailFellowshipViewModel (selected:Fellowship,app:Application):AndroidViewModel(app) {
    private val _selectedFellowship = MutableLiveData<Fellowship>()
    val selectedFellowship:LiveData<Fellowship>
    get() = _selectedFellowship

    init {
        _selectedFellowship.value = selected
    }
}