package com.smartzheng.viewmodelapp.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartzheng.viewmodelapp.R
import com.smartzheng.viewmodelapp.databinding.ActivityMainBinding
import com.smartzheng.viewmodelapp.model.entity.Movie
import com.smartzheng.viewmodelapp.ui.adapter.MovieAdapter
import com.smartzheng.viewmodelapp.ui.base.BaseActivity
import com.smartzheng.viewmodelapp.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MovieViewModel>() {
    override fun arguments(): Bundle? {
        return null
    }

    override fun viewModelClass(): Class<MovieViewModel> {
        return MovieViewModel::class.java
    }

    private val adapter: MovieAdapter by lazy {
        MovieAdapter()
    }

    override fun initViewAndData() {
        viewDataBinding.viewModel = viewModel
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        viewModel.getMovies().observe(this, androidx.lifecycle.Observer<Movie> {
            if (it != null) {
                adapter.addData(it.subjects)
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


}
