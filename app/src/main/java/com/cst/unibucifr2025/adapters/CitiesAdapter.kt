package com.cst.unibucifr2025.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.models.City
import com.cst.unibucifr2025.models.DirectionType
import com.cst.unibucifr2025.models.EastCity
import com.cst.unibucifr2025.models.NorthCity
import com.cst.unibucifr2025.models.SouthCity
import com.cst.unibucifr2025.models.WestCity
import com.cst.unibucifr2025.utils.extensions.logErrorMessage

class CitiesAdapter(
    val items: List<City>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].directionType.id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        "onCreateViewHolder".logErrorMessage()
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType) {
            DirectionType.NORTH.id -> {
                val view: View = inflater.inflate(R.layout.item_north, parent, false)
                NorthCityViewHolder(view)
            }

            DirectionType.SOUTH.id -> {
                val view: View = inflater.inflate(R.layout.item_south, parent, false)
                SouthCityViewHolder(view)
            }

            DirectionType.EAST.id -> {
                val view: View = inflater.inflate(R.layout.item_east, parent, false)
                EastCityViewHolder(view)
            }

            DirectionType.WEST.id -> {
                val view: View = inflater.inflate(R.layout.item_west, parent, false)
                WestCityViewHolder(view)
            }

            else -> {
                val view: View = inflater.inflate(R.layout.item_city, parent, false)
                return CityViewHolder(view)
            }
        }

//        val inflater = LayoutInflater.from(parent.context)
//        val view: View = inflater.inflate(R.layout.item_city, parent, false)
//        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items.getOrNull(position) ?: return

        when(holder) {
            is CityViewHolder -> holder.bind(item)

            is NorthCityViewHolder -> (item as? NorthCity)?.let { holder.bind(it) }
            is SouthCityViewHolder -> (item as? SouthCity)?.let { holder.bind(it) }
            is EastCityViewHolder -> (item as? EastCity)?.let { holder.bind(it) }
            is WestCityViewHolder -> (item as? WestCity)?.let { holder.bind(it) }
        }

        "onBindViewHolder; position = $position".logErrorMessage()
    }

    inner class CityViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(city: City) {
            view.findViewById<TextView>(R.id.tv_name).text = city.name
            view.findViewById<TextView>(R.id.tv_description).text = city.description
        }
    }

    inner class NorthCityViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(city: NorthCity) {
            view.findViewById<TextView>(R.id.tv_name).text = city.name
            view.findViewById<TextView>(R.id.tv_description).text = city.description

            val imageView = view.findViewById<ImageView>(R.id.imv_city_image)
            Glide.with(imageView.context)
                .load(city.imageUrl)
                .into(imageView)
        }
    }

    inner class SouthCityViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(city: SouthCity) {
            view.findViewById<TextView>(R.id.tv_name).text = city.name
            view.findViewById<TextView>(R.id.tv_description).text = city.description
        }
    }

    inner class EastCityViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(city: EastCity) {
            view.findViewById<TextView>(R.id.tv_name).text = city.name
            view.findViewById<TextView>(R.id.tv_description).text = city.description
        }
    }

    inner class WestCityViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(city: WestCity) {
            view.findViewById<TextView>(R.id.tv_name).text = city.name
            view.findViewById<TextView>(R.id.tv_description).text = city.description
        }
    }
}