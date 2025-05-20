package com.cst.unibucifr2025.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.models.UserModel

class UsersAdapter: ListAdapter<UserModel, UsersAdapter.UserViewHolder>(UsersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar: ImageView = itemView.findViewById(R.id.imv_avatar)
        private val fullName: TextView = itemView.findViewById(R.id.tv_full_name)
        private val email: TextView = itemView.findViewById(R.id.tv_email)

        fun bind(model: UserModel) {
            val fullNameValue = "${model.firstName} ${model.lastName}"
            fullName.text = fullNameValue

            email.text = model.email

            Glide.with(avatar.context)
                .load(model.avatar)
                .into(avatar)
        }
    }
}

private class UsersDiffCallback : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel) =
        oldItem == newItem
}