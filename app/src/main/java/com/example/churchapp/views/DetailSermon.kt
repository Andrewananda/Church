package com.example.churchapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.example.churchapp.databinding.FragmentDetailSermonBinding
import com.example.churchapp.viewmodels.DetailSermonFactory
import com.example.churchapp.viewmodels.DetailSermonViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [DetailSermon.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailSermon : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //get the application
        val application = requireNotNull(activity).application
        // Inflate the layout for this fragment
        val binding = FragmentDetailSermonBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        //get th selected sermon
        val sermonProperty = DetailSermonArgs.fromBundle(arguments!!).selectedSermon
        val sermonViewModelFactory=DetailSermonFactory(sermonProperty,application)
        binding.viewmodel = ViewModelProvider(this,sermonViewModelFactory).get(DetailSermonViewModel::class.java)
        return binding.root
    }

}
