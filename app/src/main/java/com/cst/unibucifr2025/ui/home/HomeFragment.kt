package com.cst.unibucifr2025.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.adapters.DirectionsAdapter
import com.cst.unibucifr2025.data.models.DirectionEntityModel
import com.cst.unibucifr2025.data.repositories.DirectionRepository
import com.cst.unibucifr2025.models.DirectionType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            DirectionType.EAST,
            DirectionType.WEST,
            DirectionType.NORTH,
            DirectionType.SOUTH
        ).shuffled()

        val adapter = DirectionsAdapter(items) { direction -> addDirectionIntoDatabase(direction) }

        val layoutManager = LinearLayoutManager(requireContext())

        recyclerView.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }

    fun addDirectionIntoDatabase(directionType: DirectionType) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val entity = DirectionEntityModel(
                    id = directionType.id.toLong(),
                    type = directionType
                )
                DirectionRepository.insert(entity)
            }
            goToCities(directionType.id.toLong())
        }
    }

    fun goToCities(id: Long) {
        val action = HomeFragmentDirections.actionHomeFragmentToCitiesFragment(id)
        findNavController().navigate(action)
    }
}