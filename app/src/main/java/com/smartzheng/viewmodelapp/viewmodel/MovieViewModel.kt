package com.smartzheng.viewmodelapp.viewmodel

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartzheng.viewmodelapp.model.api.ApiRequest
import com.smartzheng.viewmodelapp.model.entity.Subject
import com.smartzheng.viewmodelapp.ui.MovieAdapter

/**
 * Created by smartzheng
 * 2019/3/28
 */
class MovieViewModel : ViewModel() {
    val adapter: MovieAdapter by lazy {
        MovieAdapter(mutableListOf())
    }
    var title = MutableLiveData<String>()
    var response = ApiRequest.get().top250()
    fun afterTextChanged(s: Editable) {
        title.value = s.toString()
    }
    fun addMovies(subjects: MutableList<Subject>) {
        adapter.addMovie(subjects)
    }
}
