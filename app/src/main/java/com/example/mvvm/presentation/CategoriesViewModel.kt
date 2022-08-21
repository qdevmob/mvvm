package com.example.mvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.domain.useCase.CategoriesUseCase
import kotlinx.coroutines.launch

class CategoriesViewModel (private val categoriesUseCase: CategoriesUseCase):
    ViewModel() {

    val loadCategories = categoriesUseCase.loadCategories()


    fun migration(context: Context) = viewModelScope.launch {
        categoriesUseCase.startMigration(context)

    }


}