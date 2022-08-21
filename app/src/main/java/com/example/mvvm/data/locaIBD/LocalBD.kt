package com.example.mvvm.data.locaIBD

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.models.CategoriesModel

//Должен быть абстрактным
//база данных ЛОКАЛЬНАЯ сюда мигрируют данные с сервера
@Database(entities = [CategoriesModel::class], version = 1)
abstract class LocalDB: RoomDatabase() {
    abstract val categoriesDao: CategoriesDao

}