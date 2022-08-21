package com.example.mvvm.data.repository.dataSource

import android.content.Context

interface CategoriesApiDataSource {
    // содержит методы для получения данных с сервера
    fun startMigration (context: Context)
}
