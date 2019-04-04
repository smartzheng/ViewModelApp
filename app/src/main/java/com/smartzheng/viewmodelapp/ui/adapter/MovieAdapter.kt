package com.smartzheng.viewmodelapp.ui.adapter

import androidx.databinding.ViewDataBinding
import com.smartzheng.viewmodelapp.BR
import com.smartzheng.viewmodelapp.R
import com.smartzheng.viewmodelapp.model.entity.Subject
import com.smartzheng.viewmodelapp.ui.base.BaseBindingAdapter

/**
 * Created by smartzheng
 * 2019/3/28
 */
class MovieAdapter :
    BaseBindingAdapter<Subject, com.smartzheng.viewmodelapp.databinding.AdapterMovieBinding>(R.layout.adapter_movie) {
    override fun setVariable(dataBinding: ViewDataBinding, item: Subject) {
        dataBinding.setVariable(BR.subject, item)
    }
}