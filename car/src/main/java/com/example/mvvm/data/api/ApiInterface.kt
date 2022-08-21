package com.example.mvvm.data.api

import com.example.mvvm.data.models.CarsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //здесь вызываем все методы по работе с ДБ с сервера

    @GET("loadCars.php")
    //  @GET для получения запроса
    fun loadCarsApi(): Call<ArrayList<CarsApiModel>>
//   метод loadCarsApi сами присваиваем это имя
//    CarsApiModel Возвращает этот класс модель


}