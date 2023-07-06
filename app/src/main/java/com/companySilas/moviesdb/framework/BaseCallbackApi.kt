package com.companySilas.moviesdb.framework

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseCallbackApi<T>(private val loadingLiveData: MutableLiveData<Boolean>) : Callback<T> {

    init {
        loadingLiveData.value = true
    }

    override fun onResponse(
        call: Call<T>,
        response: Response<T>
    ) {
        loadingLiveData.value = false
//        alertStatusCode(response.code())
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        loadingLiveData.value = false
//        whenConnectTimeOut(t)
    }
}