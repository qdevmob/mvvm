package com.example.mvvm.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CategoriesModel
import com.example.mvvm.data.repository.dataSource.CategoriesApiDataSource
import com.example.mvvm.data.repository.dataSource.CategoriesDataSource
import com.example.mvvm.domain.repository.CategoriesCall

class CategoriesRepository (private val categoriesApiDataSource: CategoriesApiDataSource,
                            private val categoriesDataSource: CategoriesDataSource
): CategoriesCall {

    override fun loadCategories(): LiveData<List<CategoriesModel>> {
        return categoriesDataSource.loadCategories()
    }

    override suspend fun startMigration(context: Context) {
        categoriesDataSource.clear()
        categoriesApiDataSource.startMigration(context)
    }

}