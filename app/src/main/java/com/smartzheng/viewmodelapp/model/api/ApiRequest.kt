package com.smartzheng.viewmodelapp.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by smartzheng
 * 2019/3/28
 */
object ApiRequest {
    val retrofit = Retrofit.Builder()
        .baseUrl(ApiConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .build()
        .create(ApiService::class.java)!!

    fun get(): ApiService {
        return retrofit
    }
}