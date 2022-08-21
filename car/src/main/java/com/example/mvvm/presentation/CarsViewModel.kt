package com.example.mvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.domain.useCase.CarsUseCase
import kotlinx.coroutines.launch

class CarsViewModel (private val carsUseCase: CarsUseCase):
    ViewModel() {

    val loadCars = carsUseCase.loadCars()


    fun migration(context: Context) = viewModelScope.launch {
        carsUseCase.startMigration(context)

    }


}