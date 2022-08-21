package com.example.mvvm.data.locaIBD

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvm.data.models.CategoriesModel

//    таблица ДБ локал.
    @Dao
    interface CategoriesDao {
//    @Insert    записывает данные в соответствии с нашей моделью а она CategoriesModel
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(categoriesModel: CategoriesModel)

        @Query("SELECT * FROM categories_data_table")
        fun loadCategories(): LiveData<List<CategoriesModel>>

        @Query("DELETE FROM categories_data_table")
        suspend fun clear()
    }
