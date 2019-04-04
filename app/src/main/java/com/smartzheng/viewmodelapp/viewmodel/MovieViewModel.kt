package com.smartzheng.viewmodelapp.viewmodel

import android.annotation.SuppressLint
import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartzheng.viewmodelapp.model.api.ApiRequest
import com.smartzheng.viewmodelapp.model.entity.Movie

/**
 * Created by smartzheng
 * 2019/3/28
 */
class MovieViewModel : ViewModel() {

    var title = MutableLiveData<String>()

    private lateinit var movies: MutableLiveData<Movie>

    fun afterTextChanged(s: Editable) {
        title.postValue(s.toString())
    }

    @SuppressLint("CheckResult")
    fun getMovies(): LiveData<Movie> {
        //返回MutableLiveData
        if (!::movies.isInitialized) {
            movies = ApiRequest.getLive().top250()
        }

        //直接使用Observable
//        if (!::movies.isInitialized) {
//            movies = MutableLiveData()
//             ApiRequest.getRx()
//                .theaters()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe {
//                    movies.postValue(it)
//                }
//        }
        return movies
    }
}
