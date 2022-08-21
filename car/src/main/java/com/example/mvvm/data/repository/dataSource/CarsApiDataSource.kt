package com.example.mvvm.data.repository.dataSource

import android.content.Context

interface CarsApiDataSource {
    // содержит методы для получения данных с сервера
    fun startMigration (context: Context)
}