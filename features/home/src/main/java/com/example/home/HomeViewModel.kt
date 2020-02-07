package com.example.home

import androidx.lifecycle.*
import com.example.common.base.BaseViewModel
import com.example.common.utils.SharedViewModel
import com.example.home.domain.ProvidersListUseCase
import com.example.model.GiftCard
import com.example.model.Provider
import com.example.model.ProvidersListResponse
import com.example.repository.AppDispatchers
import com.example.repository.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val providersListUseCase: ProvidersListUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    // FOR DATA
    var sharedViewModel: SharedViewModel? = null

    private val _providersListItems = MediatorLiveData<List<Provider>>()
    val providersListItems: LiveData<List<Provider>> get() = _providersListItems

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()


    init {
        val photos: ArrayList<Provider> = ArrayList()
        _providersListItems.value = photos

        isLoading.value = false
        getProvidersListItems()
    }

    fun onPhotoClick(giftCard: GiftCard) {

        sharedViewModel?.updateData(giftCard)

        navigate(
            HomeFragmentDirections.actionHomeFragmentToGiftCardDetailsFragment()
        )
    }

    fun onRefresh() {
        isLoading.value = true
        getProvidersListItems()
    }

    private fun getProvidersListItems() = viewModelScope.launch(dispatchers.main) {
        var providersListItems: LiveData<Resource<ProvidersListResponse>> = MutableLiveData()
        withContext(dispatchers.io) {
            providersListItems = providersListUseCase()
        }
        providersListItems.observeForever(providersListItemsRequestObserver)
    }

    private val providersListItemsRequestObserver =
        Observer<Resource<ProvidersListResponse>> { resource ->

            when (resource.status) {
                Resource.Status.LOADING -> {
                    showProgressBar()
                }
                Resource.Status.ERROR -> {
                    hideProgressBar()
                    showErrorDialog(resource.error?.message.toString())
                    isLoading.value = false
                }

                Resource.Status.SUCCESS -> {
                    hideProgressBar()
                    _providersListItems.value = resource.data!!.providers
                    isLoading.value = false
                }
            }
        }
}