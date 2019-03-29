package com.smartzheng.viewmodelapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel


abstract class BaseActivity<T : ViewDataBinding, M : ViewModel> : AppCompatActivity() {
    protected lateinit var viewModel: M
    protected lateinit var viewDataBinding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewDataBinding = setViewDataBinding()
        viewDataBinding.lifecycleOwner = this
        initView()
    }

    abstract fun initView()

    private fun setViewDataBinding(): T {
        return DataBindingUtil.setContentView(this, getLayoutId())
    }

    abstract fun getLayoutId(): Int

    fun notifyDataBinding() {
        viewDataBinding.executePendingBindings()
    }
}
