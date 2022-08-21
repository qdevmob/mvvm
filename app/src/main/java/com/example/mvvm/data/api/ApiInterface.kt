package com.example.mvvm.data.api


import com.example.mvvm.data.models.CategoriesApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //здесь вызываем все методы по работе с ДБ с сервера

    @GET("loadCategories.php")
    //  @GET для получения запроса
    fun loadCategoriesApi(): Call<ArrayList<CategoriesApiModel>>
//    loadCategoriesApi сами присваиваем это имя


}