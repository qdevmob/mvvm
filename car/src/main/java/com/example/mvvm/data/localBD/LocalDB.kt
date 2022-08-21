package com.example.mvvm.data.localBD

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.models.CarsModel

//Должен быть абстрактным
//база данных ЛОКАЛЬНАЯ сюда мигрируют данные с сервера
@Database(entities = [CarsModel::class], version = 1)
abstract class LocalDB: RoomDatabase() {
    abstract val carsDao: CarsDao
}
