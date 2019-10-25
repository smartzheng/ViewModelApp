package com.smartzheng.viewmodelapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders


abstract class BaseActivity<T : ViewDataBinding, M : ViewModel> : AppCompatActivity() {
    protected lateinit var viewModel: M
    protected lateinit var viewDataBinding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = initViewModel()
        viewDataBinding = setViewDataBinding()
        viewDataBinding.lifecycleOwner = this
        initViewAndData()
    }

    private fun initViewModel(): M {
        return ViewModelProviders.of(this, ViewModelFactory(this, arguments())).get(viewModel::class.java)
    }

    abstract fun arguments(): Bundle?

    abstract fun viewModelClass(): Class<M>

    abstract fun initViewAndData()

    private fun setViewDataBinding(): T {
        return DataBindingUtil.setContentView(this, getLayoutId())
    }

    abstract fun getLayoutId(): Int

    fun notifyDataBinding() {
        viewDataBinding.executePendingBindings()
    }
}
