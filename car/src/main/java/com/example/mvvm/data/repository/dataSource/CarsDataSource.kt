package com.example.mvvm.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CarsModel

// это интерфейс локальной БД

interface CarsDataSource {
    fun insert(carsModel: CarsModel)

    fun loadCars(): LiveData<List<CarsModel>>

    suspend fun clear()

}
//    для работы с локальной БД