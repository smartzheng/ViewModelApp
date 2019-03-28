package com.smartzheng.viewmodelapp.model.api

import androidx.lifecycle.LiveData
import com.smartzheng.viewmodelapp.model.entity.Movie
import retrofit2.http.GET


/**
 * Created by smartzheng
 * 2019/3/28
 */
interface ApiService {
    @GET(ApiConfig.TOP250)
    fun top250(): LiveData<Movie>

    @GET(ApiConfig.THEATERS)
    fun theaters(): LiveData<Movie>
}