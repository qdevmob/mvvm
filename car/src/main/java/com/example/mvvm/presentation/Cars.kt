package com.example.mvvm.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.databinding.CarsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class Cars : Fragment() {
    private var binding: CarsBinding? = null
    private var carsAdapter: CarsAdapter? = null
    private val carsViewModel: CarsViewModel by viewModel()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.cars, container, false)

        initRecyclerCars()

        loadCars()

        return binding?.root


    }

    private fun initRecyclerCars(){
        binding?.recyclerCars?.layoutManager = LinearLayoutManager(context)
        carsAdapter = CarsAdapter()
        binding?.recyclerCars?.adapter = carsAdapter

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun loadCars(){
        carsViewModel.loadCars.observe(viewLifecycleOwner, Observer {
            carsAdapter?.setList(it)
            carsAdapter?.notifyDataSetChanged()
        })
    }


}
