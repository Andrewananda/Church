package com.example.churchapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.churchapp.R
import com.example.churchapp.databinding.FragmentDetailEventBinding
import com.example.churchapp.databinding.FragmentEventBinding
import com.example.churchapp.viewmodels.DetailEventViewModel
import com.example.churchapp.viewmodels.EventViewModel
import com.example.churchapp.viewmodels.EventViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class DetailEvent : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        // Inflate the layout for this fragment
        val binding = FragmentDetailEventBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        //get viewmodel and set the selected Event
        val selectedEvent = DetailEventArgs.fromBundle(arguments!!).selectedEvent
        val eventFactory = EventViewModelFactory(selectedEvent,application)
        binding.viewModel = ViewModelProvider(this,eventFactory).get(DetailEventViewModel::class.java)

        return binding.root
    }

}
