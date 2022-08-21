package com.example.mvvm.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CategoriesModel


interface CategoriesDataSource {

    fun insert(categoriesModel: CategoriesModel)

    fun loadCategories(): LiveData<List<CategoriesModel>>

    suspend fun clear()

}
    //    для работы с локальной БД
