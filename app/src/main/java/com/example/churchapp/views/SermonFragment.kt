package com.example.churchapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.churchapp.R

import com.example.churchapp.adapters.SermonAdapter
import com.example.churchapp.databinding.FragmentSermonBinding
import com.example.churchapp.viewmodels.Sermonviewmodel

/**
 * A simple [Fragment] subclass.
 * Use the [SermonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SermonFragment : Fragment() {
    private lateinit var binding:FragmentSermonBinding
    private val viewModel:Sermonviewmodel by lazy {
        ViewModelProvider(this).get(Sermonviewmodel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sermon,container,false)
        binding.setLifecycleOwner(this)
        binding.viewmodel = viewModel
        val adapter = SermonAdapter(SermonAdapter.OnClickListener{
            viewModel.displaySelectedSermon(it)
        })
        //set adapter
        binding.sermonRecyclerview.adapter = adapter
        viewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        //Observe click event
        viewModel.navigateToSelectedSermon.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(SermonFragmentDirections.actionSermonFragmentToDetailSermon(it))
                viewModel.displaySelectedSermonComplete()
            }
        })


        return binding.root
    }

}
