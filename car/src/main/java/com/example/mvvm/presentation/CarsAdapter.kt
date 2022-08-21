package com.example.mvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.models.CarsModel
import com.example.mvvm.databinding.CarsItemBinding
import com.squareup.picasso.Picasso

class CarsAdapter: RecyclerView.Adapter<CarsAdapter.CarsHolder>() {

    private val carsList = ArrayList<CarsModel>()
    //    класс <модель> по которой будем собирать CarsModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CarsItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.cars_item, parent, false)
        return CarsHolder(binding)

    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    override fun onBindViewHolder(holder: CarsHolder, position: Int) {
        holder.bind(carsList[position])
    }

    fun setList(cars: List<CarsModel>) {
        carsList.clear()
        carsList.addAll(cars)

    }
    class CarsHolder (private val binding: CarsItemBinding) : RecyclerView.ViewHolder(binding.root){
     fun  bind(
         cars: CarsModel
     ) {


    val getImage = cars.image
    Picasso.get().load(getImage).into(binding.imageCars)
         binding.idCars.text = cars.id.toString()
         binding.nameCars.text = cars.name
         binding.yearCars.text = cars.year
         binding.priceCars.text = cars.price

}

}

}
