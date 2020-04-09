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
import com.example.churchapp.adapters.FellowshipAdapter
import com.example.churchapp.databinding.FragmentFellowshipBinding
import com.example.churchapp.viewmodels.FellowshipViewModel

/**
 * A simple [Fragment] subclass.
 */
class FragmentFellowship : Fragment() {
private val viewmodel:FellowshipViewModel by lazy {
    ViewModelProvider(this).get(FellowshipViewModel::class.java)
}
private lateinit var binding:FragmentFellowshipBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_fellowship,container,false)
        binding.setLifecycleOwner(this)
        binding.viewmodel = viewmodel
        //adding adapter and submitting new list if updated
        val adapter = FellowshipAdapter(FellowshipAdapter.OnClickListener{
            viewmodel.showSelectedFellowship(it)
        })
        binding.fellowshipRecyclerview.adapter = adapter
        viewmodel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        viewmodel.navigateToSelectedFellowship.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(FragmentFellowshipDirections.actionFragmentFellowshipToSingleFellowship(it))
                viewmodel.showSelectedFellowshipDone()
            }
        })

        return binding.root
    }

}
