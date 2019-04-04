package com.smartzheng.viewmodelapp.viewmodel

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

    private lateinit var movies: LiveData<Movie>

    fun afterTextChanged(s: Editable) {
        title.value = s.toString()
    }

    fun getMovies(): LiveData<Movie> {
        if (!::movies.isInitialized) {
            movies = ApiRequest.get().top250()
        }
        return movies
    }
}
