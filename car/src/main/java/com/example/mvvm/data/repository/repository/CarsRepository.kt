package com.example.mvvm.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CarsModel
import com.example.mvvm.data.repository.dataSource.CarsApiDataSource
import com.example.mvvm.data.repository.dataSource.CarsDataSource
import com.example.mvvm.domain.repository.CarsCall

// Переопределяем методы здесь ООП
class CarsRepository (private val carsApiDataSource: CarsApiDataSource,
                      private val carsDataSource: CarsDataSource
): CarsCall {

    override fun loadCars(): LiveData<List<CarsModel>> {
        return carsDataSource.loadCars()
    }

    override suspend fun startMigration(context: Context) {
        carsDataSource.clear()
        carsApiDataSource.startMigration(context)
    }

}