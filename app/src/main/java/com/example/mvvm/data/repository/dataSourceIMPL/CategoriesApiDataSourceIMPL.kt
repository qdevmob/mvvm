package com.example.mvvm.data.repository.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.example.mvvm.data.api.ApiClient
import com.example.mvvm.data.models.CategoriesApiModel
import com.example.mvvm.data.models.CategoriesModel
import com.example.mvvm.data.repository.dataSource.CategoriesApiDataSource
import com.example.mvvm.data.repository.dataSource.CategoriesDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// этот класс содержит методы для получения данных с сервера
class CategoriesApiDataSourceIMPL (private val categoriesDataSource: CategoriesDataSource):
    CategoriesApiDataSource {



        override fun startMigration (context: Context) {

            val call = ApiClient.instance?.api?.loadCategoriesApi()
            call?.enqueue(object: Callback<ArrayList<CategoriesApiModel>> {
//                CategoriesApiModel класс таблицы БД КОТОРЫЙ МЫ ПОЛУЧАЕМ С СЕРВЕРА
                override fun onResponse(
                    call: Call<ArrayList<CategoriesApiModel>>,
                    response: Response<ArrayList<CategoriesApiModel>>
                ) {


                    var loadCategories: ArrayList<CategoriesApiModel>? = null

                    loadCategories?.clear()

                    loadCategories = (response.body() as ArrayList<CategoriesApiModel>?)!!

                    for (audit in loadCategories) {

                        audit.id?.let {
                            CategoriesModel(
                                it,
                                audit.name.toString(),
                                audit.image.toString()

                            )
                        }?.let {
                            categoriesDataSource.insert(
                                it
                            )
                        }

                    }

                    Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


                }

                override fun onFailure(call: Call<ArrayList<CategoriesApiModel>>, t: Throwable) {
                    Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

                }
            })

        }

    }
// содержит методы для получения данных с сервера
