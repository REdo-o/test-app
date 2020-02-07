package com.example.remote


import com.example.model.ProvidersListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ProviderService {

    @GET(" ")
    fun getProvidersAsync(): Deferred<ProvidersListResponse>

}