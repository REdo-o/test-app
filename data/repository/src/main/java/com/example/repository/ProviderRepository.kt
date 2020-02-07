package com.example.repository

import androidx.lifecycle.LiveData
import com.example.model.ProvidersListResponse
import com.example.remote.ProviderDatasource
import com.example.repository.utils.NetworkBoundResource
import com.example.repository.utils.Resource
import kotlinx.coroutines.Deferred

interface ProviderRepository {

    suspend fun getProviders()
            : LiveData<Resource<ProvidersListResponse>>

    class ProviderRepositoryImpl(
        private val dataSource: ProviderDatasource
    ) : ProviderRepository {

        override suspend fun getProviders():
                LiveData<Resource<ProvidersListResponse>> {
            return object :
                NetworkBoundResource<ProvidersListResponse, ProvidersListResponse>() {

                override fun processResponse(response: ProvidersListResponse): Resource<ProvidersListResponse> {
                    return Resource.success(response)
                }

                override fun createCallAsync(): Deferred<ProvidersListResponse> =
                    dataSource.getProvidersAsync()

            }.build().asLiveData()
        }
    }
}