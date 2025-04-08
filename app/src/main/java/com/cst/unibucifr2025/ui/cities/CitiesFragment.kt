package com.cst.unibucifr2025.ui.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.data.models.CityEntityModel
import com.cst.unibucifr2025.data.repositories.CityRepository

class CitiesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cities, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.insert_city_button).setOnClickListener{
            CityRepository.insert(generateRandomCity())
        }
    }

    fun generateRandomCity():CityEntityModel {
        val cityNames = listOf("Bucuresti", "Cluj", "Iasi", "Brasov", "Timisoara")
        return CityEntityModel(name = cityNames.random())
    }

}