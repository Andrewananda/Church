package com.example.churchapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.churchapp.models.Sermon

class DetailSermonViewModel(selected:Sermon,app:Application) : AndroidViewModel(app){
    private val _selectedSermon = MutableLiveData<Sermon>()
    val selectedSermon:LiveData<Sermon>
    get() = _selectedSermon

    init {
        _selectedSermon.value = selected
    }

}