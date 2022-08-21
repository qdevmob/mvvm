package com.example.mvvm.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.example.mvvm.data.locaIBD.CategoriesDao
import com.example.mvvm.data.models.CategoriesModel
import com.example.mvvm.data.repository.dataSource.CategoriesDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//    для работы с локальной БД
class CategoriesDataSourceIMPL (private val dao: CategoriesDao):
    CategoriesDataSource {


    override fun insert(categoriesModel: CategoriesModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(categoriesModel)}
    }

    override fun loadCategories(): LiveData<List<CategoriesModel>> {
        return dao.loadCategories()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}
