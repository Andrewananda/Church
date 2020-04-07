package com.example.churchapp.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.churchapp.models.Sermon

class DetailSermonFactory(
    private val sermon: Sermon,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailSermonViewModel::class.java)) {
            return DetailSermonViewModel(sermon, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}