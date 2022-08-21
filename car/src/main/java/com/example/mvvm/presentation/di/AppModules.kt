package com.example.mvvm.presentation.di

import androidx.room.Room
import com.example.mvvm.data.localBD.LocalDB
import com.example.mvvm.data.repository.dataSource.CarsApiDataSource
import com.example.mvvm.data.repository.dataSource.CarsDataSource
import com.example.mvvm.data.repository.dataSourse.IMPL.CarsApiDataSourceIMPL
import com.example.mvvm.data.repository.dataSourse.IMPL.CarsDataSourceIMPL
import com.example.mvvm.data.repository.repository.CarsRepository
import com.example.mvvm.domain.repository.CarsCall
import com.example.mvvm.domain.useCase.CarsUseCase
import com.example.mvvm.presentation.CarsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleCars = module {

    single {
        Room.databaseBuilder(androidContext(), LocalDB::class.java,
            "localDB").build()
    }

    single { get<LocalDB>().carsDao }


    single<CarsDataSource> {
        CarsDataSourceIMPL(
            get()
        )
    }

    single<CarsApiDataSource> {
        CarsApiDataSourceIMPL(
            get()
        )
    }

    single<CarsCall> { CarsRepository(get(),get()) }
//  get(),get()  передаем два метода интерфейса
    single { CarsUseCase(get()) }

    viewModel  { CarsViewModel(get()) }

}