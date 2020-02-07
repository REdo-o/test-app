package com.example.repository.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.io.IOException
import kotlin.coroutines.coroutineContext


abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MutableLiveData<Resource<ResultType>>()
    private val supervisorJob = SupervisorJob()

    suspend fun build(): NetworkBoundResource<ResultType, RequestType> {
        withContext(Dispatchers.Main) {
            result.value =
                Resource.loading(null)
        }
        CoroutineScope(coroutineContext).launch(supervisorJob) {
            try {
                fetchFromNetwork()
            } catch (e: Exception) {
                setValue(Resource.error(e, null))
            }
        }
        return this
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

// ---

    private suspend fun fetchFromNetwork() {
        Log.d(NetworkBoundResource::class.java.name, "Fetch data from network")
        setValue(Resource.loading(null)) // Dispatch latest value quickly (UX purpose)
        try {
            val apiResponse = createCallAsync().await()
            setValue(processResponse(apiResponse))
        } catch (exception: IOException) {
            setValue(Resource(Resource.Status.ERROR, null, exception))
        }
        Log.e(NetworkBoundResource::class.java.name, "Data fetched from network")
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        Log.d(NetworkBoundResource::class.java.name, "Resource: " + newValue)
        result.postValue(newValue)
    }

    @WorkerThread
    protected abstract fun processResponse(response: RequestType): Resource<ResultType>

    @MainThread
    protected abstract fun createCallAsync(): Deferred<RequestType>
}