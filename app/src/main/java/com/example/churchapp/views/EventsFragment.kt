package com.example.churchapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.churchapp.R
import com.example.churchapp.adapters.EventAdapter
import com.example.churchapp.databinding.FragmentEventsBinding
import com.example.churchapp.viewmodels.EventViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [EventsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventsFragment : Fragment() {
private val viewModel:EventViewModel by lazy {
    ViewModelProvider(this).get(EventViewModel::class.java)
}
private lateinit var binding:FragmentEventsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding  = DataBindingUtil.inflate(inflater,R.layout.fragment_events,container,false)
        binding.setLifecycleOwner(this)
        binding.viewmodel = viewModel
        val adapter = EventAdapter()
        binding.eventRecyclerview.adapter = adapter
        viewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })


        return binding.root
    }
}
