package com.example.churchapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.churchapp.R
import com.example.churchapp.databinding.FragmentSingleFellowshipBinding
import com.example.churchapp.viewmodels.DetailFellowshipViewModel
import com.example.churchapp.viewmodels.FellowshipViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class SingleFellowship : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        // Inflate the layout for this fragment
        val binding = FragmentSingleFellowshipBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        //get selected fellowship and display
        val selectedFellowship = SingleFellowshipArgs.fromBundle(arguments!!).selectedFellowship
        val fellowshipFactory = FellowshipViewModelFactory(selectedFellowship,application)
        binding.viewmodel = ViewModelProvider(this,fellowshipFactory).get(DetailFellowshipViewModel::class.java)

        return binding.root
    }

}
