package com.example.mvvm.data.localBD

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.data.models.CarsModel

//    методы по работе ДБ локал.
// МИГРАЦИЯ ЗДЕСЬ
@Dao
interface CarsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(carsModel: CarsModel)
//    Начало миграции
//    insert метод создания записи
    // метод   insert    записывает данные в соответствии с нашей моделью а она CarsModel

    @Query("SELECT * FROM cars_data_table")
    fun loadCars(): LiveData<List<CarsModel>>

    @Query("DELETE FROM cars_data_table")
    suspend fun clear()
}
