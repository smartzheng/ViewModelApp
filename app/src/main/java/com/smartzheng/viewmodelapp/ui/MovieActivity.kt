package com.smartzheng.viewmodelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.smartzheng.viewmodelapp.R
import com.smartzheng.viewmodelapp.databinding.ActivityMovieBinding
import com.smartzheng.viewmodelapp.model.entity.Movie
import com.smartzheng.viewmodelapp.viewmodel.MovieViewModel

class MovieActivity : AppCompatActivity() {

    private lateinit var vm: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        val viewDataBinding = DataBindingUtil.setContentView<ActivityMovieBinding>(this, R.layout.activity_movie)
        vm = ViewModelProviders.of(this, ViewModelProvider.NewInstanceFactory()).get(MovieViewModel::class.java)
        viewDataBinding.model = vm
        viewDataBinding.lifecycleOwner = this
        vm.response.observe(this, Observer<Movie> {
            if (it != null) {
                vm.adapter.addMovie(it.subjects)
                viewDataBinding.executePendingBindings()
            }
        })
    }
}
