package com.example.mvvm.data.repository.dataSourse.IMPL

import androidx.lifecycle.LiveData
import com.example.mvvm.data.localBD.CarsDao
import com.example.mvvm.data.models.CarsModel
import com.example.mvvm.data.repository.dataSource.CarsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//    для работы с локальной БД
class CarsDataSourceIMPL (private val dao: CarsDao):
    CarsDataSource {


    override fun insert(carsModel: CarsModel) {
        CoroutineScope(Dispatchers.IO).launch {
//            Корутины многопоточнось
            dao.insert(carsModel)}
    }

    override fun loadCars(): LiveData<List<CarsModel>> {
        return dao.loadCars()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}