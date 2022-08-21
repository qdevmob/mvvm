package com.example.mvvm.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CarsModel
import com.example.mvvm.domain.repository.CarsCall

class CarsUseCase (private val carsCall: CarsCall){

    fun loadCars(): LiveData<List<CarsModel>> {
        return carsCall.loadCars()
    }

      suspend fun startMigration(context: Context) {

        carsCall.startMigration(context)
    }

}
