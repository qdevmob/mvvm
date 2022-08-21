package com.example.mvvm.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//    таблица ДБ локал.
//    поля для ДБ локал

@Entity(tableName = "cars_data_table")
//  cars_data_table даем уникальное название для таблицы БД
class CarsModel (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "cars_id")
    val id:Int,

    @ColumnInfo(name = "cars_name")
    val name:String,

    @ColumnInfo(name = "cars_year")
    val year:String,

    @ColumnInfo(name = "cars_price")
    val price:String,

    @ColumnInfo(name = "cars_image")
    val image:String
    )
