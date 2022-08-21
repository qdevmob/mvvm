package com.example.mvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.models.CategoriesModel
import com.example.mvvm.databinding.CategoryItemBinding
import com.squareup.picasso.Picasso

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private val categoriesList = ArrayList<CategoriesModel>()
//    класс <модель> по которой будем собирать CategoriesModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CategoryItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.category_item, parent, false)
        return CategoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    fun setList(categories: List<CategoriesModel>) {
        categoriesList.clear()
        categoriesList.addAll(categories)

    }


    class CategoryHolder(private val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            categories: CategoriesModel
        ) {

            val getImage = categories.image
            Picasso.get().load(getImage).into(binding.imageCategory)
            binding.idCategory.text = categories.id.toString()
            binding.nameCategory.text = categories.name

        }

    }

}
