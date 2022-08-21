package com.example.mvvm.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CarsModel

interface CarsCall {
    fun loadCars(): LiveData<List<CarsModel>>

    suspend fun startMigration(context: Context)
}