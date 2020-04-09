package com.example.churchapp.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.churchapp.models.Fellowship

class FellowshipViewModelFactory(
    private val fellowship: Fellowship,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailFellowshipViewModel::class.java)) {
            return DetailFellowshipViewModel(fellowship, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}