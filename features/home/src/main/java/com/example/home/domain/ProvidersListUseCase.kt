package com.example.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.model.ProvidersListResponse
import com.example.repository.ProviderRepository
import com.example.repository.utils.Resource

class ProvidersListUseCase(private val repository: ProviderRepository) {

    suspend operator fun invoke():
            LiveData<Resource<ProvidersListResponse>> {
        return Transformations.map(repository.getProviders()) {
            it // Place here your specific logic actions
        }
    }
}