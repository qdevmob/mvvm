package com.example.mvvm.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CategoriesModel
import com.example.mvvm.domain.repository.CategoriesCall

class CategoriesUseCase (private val categoriesCall: CategoriesCall) {


    fun loadCategories(): LiveData<List<CategoriesModel>> {

        return categoriesCall.loadCategories()

    }

    suspend fun startMigration (context: Context) {

        categoriesCall.startMigration(context)

    }
}
