package com.cst.unibucifr2025.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.adapters.CitiesAdapter
import com.cst.unibucifr2025.models.City
import com.cst.unibucifr2025.models.DirectionType
import com.cst.unibucifr2025.models.EastCity
import com.cst.unibucifr2025.models.NorthCity
import com.cst.unibucifr2025.models.SouthCity
import com.cst.unibucifr2025.models.West
import com.cst.unibucifr2025.models.WestCity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_items)

        val items = listOf(
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
            SouthCity("Bucharest", "Description 1"),
            NorthCity("Paris", "Description 2"),
            EastCity("Barcelona", "Description 3"),
            WestCity("Cairo", "Description 4"),
            SouthCity("Budapest", "Description 5"),
        ).shuffled()

        val adapter = CitiesAdapter(items) {
            goToCities()
        }

        val layoutManager = LinearLayoutManager(requireContext())

        recyclerView.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }

    fun goToCities() {
        val action = HomeFragmentDirections.actionHomeFragmentToCitiesFragment()
        findNavController().navigate(action)
    }
}