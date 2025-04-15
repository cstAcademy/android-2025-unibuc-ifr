package com.cst.unibucifr2025.ui.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.data.models.CityEntityModel
import com.cst.unibucifr2025.data.repositories.CityRepository
import com.cst.unibucifr2025.data.repositories.DirectionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CitiesFragment : Fragment() {
    val args: CitiesFragmentArgs by navArgs()

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
        view.findViewById<Button>(R.id.get_directions_city).setOnClickListener{
            getDirectionsWithCities()
        }
    }

    fun generateRandomCity():CityEntityModel {
        val cityNames = listOf("Bucuresti", "Cluj", "Iasi", "Brasov", "Timisoara")
        return CityEntityModel(name = cityNames.random(), ownerId = args.directionId)
    }

    fun getDirectionsWithCities(){
        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO){
                DirectionRepository.getAllDirectionsWithCities()
            }
            view?.findViewById<TextView>(R.id.tv_result)?.text = result.toString()
        }
    }

}