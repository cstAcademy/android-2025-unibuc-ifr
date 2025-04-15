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

class DirectionsAdapter(
    val items: List<DirectionType>,
    val onItemClick: (DirectionType) -> Unit
) : RecyclerView.Adapter<DirectionsAdapter.DirectionViewHolder>() {

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectionViewHolder {
        "onCreateViewHolder".logErrorMessage()
        val inflater = LayoutInflater.from(parent.context)

        val view: View = inflater.inflate(R.layout.item_direction, parent, false)
        return DirectionViewHolder(view)

    }

    override fun onBindViewHolder(holder: DirectionViewHolder, position: Int) {
        val item = items.getOrNull(position) ?: return
        holder.bind(item)

        "onBindViewHolder; position = $position".logErrorMessage()
    }

    inner class DirectionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(direction: DirectionType) {
            view.findViewById<TextView>(R.id.tv_name).text =
                view.context.getString(direction.resourceId)
            view.setOnClickListener{
                onItemClick.invoke(direction)
            }
        }
    }

}