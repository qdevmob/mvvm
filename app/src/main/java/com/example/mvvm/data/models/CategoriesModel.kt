package com.example.mvvm.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//    таблица ДБ локал.
    //    поля

    @Entity(tableName = "categories_data_table")
    class CategoriesModel (

        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "categories_id")
        val id:Int,

        @ColumnInfo(name = "categories_name")
        val name:String,

        @ColumnInfo(name = "categories_image")
        val image:String

    )
