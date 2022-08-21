package com.example.mvvm.presentation.di

import androidx.room.Room
import com.example.mvvm.data.locaIBD.LocalDB
import com.example.mvvm.data.repository.dataSource.CategoriesApiDataSource
import com.example.mvvm.data.repository.dataSource.CategoriesDataSource
import com.example.mvvm.data.repository.dataSourceIMPL.CategoriesApiDataSourceIMPL
import com.example.mvvm.data.repository.dataSourceIMPL.CategoriesDataSourceIMPL
import com.example.mvvm.data.repository.repository.CategoriesRepository
import com.example.mvvm.domain.repository.CategoriesCall
import com.example.mvvm.domain.useCase.CategoriesUseCase
import com.example.mvvm.presentation.CategoriesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleCategories = module {

    single {
        Room.databaseBuilder(androidContext(), LocalDB::class.java,
            "localDB").build()
    }

    single { get<LocalDB>().categoriesDao }


    single<CategoriesDataSource> {
        CategoriesDataSourceIMPL(
            get()
        )
    }

    single<CategoriesApiDataSource> {
        CategoriesApiDataSourceIMPL(
            get()
        )
    }

    single<CategoriesCall> { CategoriesRepository(get(),get()) }
//  get(),get()  передаем два метода интерфейса
    single { CategoriesUseCase(get()) }

    viewModel  { CategoriesViewModel(get()) }

}