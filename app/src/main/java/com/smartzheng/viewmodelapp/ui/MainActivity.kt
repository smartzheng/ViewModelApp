package com.smartzheng.viewmodelapp.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartzheng.viewmodelapp.R
import com.smartzheng.viewmodelapp.databinding.ActivityMainBinding
import com.smartzheng.viewmodelapp.model.entity.Movie
import com.smartzheng.viewmodelapp.ui.base.BaseActivity
import com.smartzheng.viewmodelapp.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MovieViewModel>() {
    val adapter: MovieAdapter by lazy {
        MovieAdapter()
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this, ViewModelProvider.NewInstanceFactory()).get(MovieViewModel::class.java)
        viewDataBinding.viewModel = viewModel
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        viewModel.getMovies().observe(this, Observer<Movie> {
            if (it != null) {
                adapter.addData(it.subjects)
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
