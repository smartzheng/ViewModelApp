package com.smartzheng.viewmodelapp.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.smartzheng.viewmodelapp.R
import com.smartzheng.viewmodelapp.databinding.ActivityMainBinding
import com.smartzheng.viewmodelapp.model.entity.Movie
import com.smartzheng.viewmodelapp.ui.base.BaseActivity
import com.smartzheng.viewmodelapp.viewmodel.MovieViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MovieViewModel>() {

    override fun initView() {
        viewModel = ViewModelProviders.of(this, ViewModelProvider.NewInstanceFactory()).get(MovieViewModel::class.java)
        viewDataBinding.model = viewModel
        viewModel.response.observe(this, Observer<Movie> {
            if (it != null) {
                viewModel.adapter.addData(it.subjects)
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
