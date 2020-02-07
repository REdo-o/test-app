package com.example.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.common.utils.Event
import com.example.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    // FOR PROGRESSBAR HANDLER
    private val _progressBar = MutableLiveData<Event<Boolean>>()
    val progressBar: LiveData<Event<Boolean>> get() = _progressBar

    // FOR ERROR DIALOG STRING HANDLER
    private val _dialogErrorString = MutableLiveData<Event<String>>()
    val dialogErrorString: LiveData<Event<String>> get() = _dialogErrorString

    // FOR NAVIGATION
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }

    fun showProgressBar() {
        _progressBar.value = Event(true)
    }

    fun hideProgressBar() {
        _progressBar.value = Event(false)
    }

    fun showErrorDialog(error: String) {
        _dialogErrorString.value = Event(error)
    }
}