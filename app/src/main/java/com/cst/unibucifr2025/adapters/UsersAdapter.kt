package com.cst.unibucifr2025.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cst.unibucifr2025.R
import com.cst.unibucifr2025.models.UserModel

class UsersAdapter(
    private var items: List<UserModel> = listOf()
): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        items.getOrNull(position)?.let { item ->
            holder.bind(item)
        }
    }

    fun updateList(newList: List<UserModel>) {
        val diffResult = DiffUtil.calculateDiff(UsersDiffCallback(items, newList))
        items = newList
        diffResult.dispatchUpdatesTo(this)
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

    inner class UsersDiffCallback(
        private val oldList: List<UserModel>,
        private val newList: List<UserModel>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}