package com.cst.unibucifr2025.networking.repository

import com.cst.unibucifr2025.networking.api.AuthenticationApiService
import com.cst.unibucifr2025.networking.client.RetrofitClient
import com.cst.unibucifr2025.networking.models.LoginAPIRequestModel

object AuthenticationRepository {
    private val authenticationApiService by lazy {
        RetrofitClient.nonAuthInstance.create(AuthenticationApiService::class.java)
    }

    suspend fun login(email: String, password: String) =
        authenticationApiService.login(LoginAPIRequestModel(email, password))
}