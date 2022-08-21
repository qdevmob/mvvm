package com.example.mvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null
      private val categoriesViewMode:CategoriesViewModel by viewModel()
//     указываем что это обьект viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
//    this    сама сущность



        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
//        по умолчанию подгружаем вкладку Home ()

        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav
//        в качестве активной вкладки homeItemBottomNav


        binding?.bottomNav?.setOnItemSelectedListener { item ->
//            метод обработки табов

            when(item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
//                при табе запускаем Home()
                R.id.categoriesItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Categories()).commit()

            }

            return@setOnItemSelectedListener true
        }

        categoriesViewMode.migration(this)
    }


}
