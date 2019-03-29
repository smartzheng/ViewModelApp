package com.smartzheng.viewmodelapp.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.smartzheng.viewmodelapp.R

/**
 * Created by smartzheng
 * 2019/3/29
 */
abstract class BaseBindingAdapter<T, M : ViewDataBinding>(@LayoutRes id: Int) :
    BaseQuickAdapter<T, RecyclerViewHolder>(id) {
    override fun convert(helper: RecyclerViewHolder, item: T) {
        setVariable(helper.dataBinding, item)
        helper.dataBinding.executePendingBindings()
    }

    abstract fun setVariable(dataBinding: ViewDataBinding, item: T)
    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        val binding = DataBindingUtil.inflate<M>(
            mLayoutInflater,
            layoutResId,
            parent,
            false
        ) ?: return super.getItemView(layoutResId, parent)
        val view = binding.root
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        return view
    }

}

class RecyclerViewHolder(view: View) : BaseViewHolder(view) {
    var dataBinding: ViewDataBinding =
        itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
}