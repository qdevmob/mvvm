package com.example.mvvm.data.repository.dataSourse.IMPL

import android.content.Context
import android.widget.Toast
import com.example.mvvm.data.api.ApiClient
import com.example.mvvm.data.models.CarsApiModel
import com.example.mvvm.data.models.CarsModel
import com.example.mvvm.data.repository.dataSource.CarsApiDataSource
import com.example.mvvm.data.repository.dataSource.CarsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// этот класс содержит методы для получения данных с сервера и МИГРАЦИЯ В локальную БД
class CarsApiDataSourceIMPL (private val carsDataSource: CarsDataSource):
    CarsApiDataSource {



    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.loadCarsApi()
        call?.enqueue(object: Callback<ArrayList<CarsApiModel>> {
            //                CategoriesApiModel класс таблицы БД КОТОРЫЙ МЫ ПОЛУЧАЕМ С СЕРВЕРА
            override fun onResponse(
                call: Call<ArrayList<CarsApiModel>>,
                response: Response<ArrayList<CarsApiModel>>
            ) {


                var loadCars: ArrayList<CarsApiModel>? = null

                loadCars?.clear()

                loadCars = response.body()!!

                for (audit in loadCars) {

                    audit.id?.let {
                        CarsModel(
                            it,
                            audit.name.toString(),
                            audit.year.toString(),
                            audit.price.toString(),
                            audit.image.toString()
                        )
                    }?.let {
                        carsDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
//                loader.visibility = View.GONE



            }

            override fun onFailure(call: Call<ArrayList<CarsApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }


}
// содержит методы для получения данных с сервера
