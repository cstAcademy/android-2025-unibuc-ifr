package com.cst.unibucifr2025.networking.repository

import com.cst.unibucifr2025.networking.api.UserApiService
import com.cst.unibucifr2025.networking.client.RetrofitClient

object UserRepository {
    private val userApiService by lazy {
        RetrofitClient.instance.create(UserApiService::class.java)
    }

    suspend fun getUsers(page: Int) = userApiService.getUsers(page)
}