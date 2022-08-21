package com.example.mvvm.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.data.models.CategoriesModel

interface CategoriesCall {
   fun loadCategories(): LiveData<List<CategoriesModel>>

    suspend fun startMigration(context: Context)
}