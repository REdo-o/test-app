package com.example.remote

class ProviderDatasource(private val providerService: ProviderService) {

    fun getProvidersAsync() =
        providerService.getProvidersAsync()

}