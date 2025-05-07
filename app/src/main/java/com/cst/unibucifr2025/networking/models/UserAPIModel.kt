package com.cst.unibucifr2025.networking.models

import com.cst.unibucifr2025.models.UserModel

data class UserListAPIResponseModel(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<UserModel>
)