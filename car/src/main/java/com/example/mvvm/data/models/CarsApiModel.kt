package com.example.mvvm.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


//ЗДЕСЬ ДОЛЖНЫ БЫТЬ ТАКИЕ ЖЕ ПОЛЯ КАК У БД НА СЕРВЕРЕ
data class CarsApiModel (
    //это класс конструктор API
    @SerializedName("id") @Expose
    var id: Int? = null,
    @SerializedName("name") @Expose
    var name: String? = null,
    @SerializedName("year") @Expose
    var year: String? = null,
    @SerializedName("price") @Expose
    var price: String? = null,
    @SerializedName("image") @Expose
    var image: String? = null
        )