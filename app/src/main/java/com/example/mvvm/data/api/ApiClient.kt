package com.example.mvvm.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {
    //работает с  нашей БД msql

    val api: ApiInterface
        get() = retrofit!!.create(
            ApiInterface::class.java)

    init {

        retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    companion object {

        private const val BASE_URL = "http://mvvm.qdevmo2z.beget.tech/"
        /////  ссылка на домен.ru
        private var apiClient: ApiClient? = null
        private var retrofit: Retrofit? = null

        val instance: ApiClient?
            //подключаем Retrofit
            @Synchronized get() {

                if (apiClient == null) {

                    apiClient =
                        ApiClient()
                }

                return apiClient


            }

    }
}