package com.smartzheng.viewmodelapp.model.api

import androidx.lifecycle.MutableLiveData
import com.smartzheng.viewmodelapp.model.entity.Movie
import retrofit2.http.GET


/**
 * Created by smartzheng
 * 2019/3/28
 */
interface ApiService {
    //自定义callAdapter直接返回MutableLiveData
    @GET(ApiConfig.TOP250)
    fun top250(): MutableLiveData<Movie>
    //常见使用方式
//    @GET(ApiConfig.THEATERS)
//    fun theaters(): Observable<Movie>
}