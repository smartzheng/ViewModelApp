package com.smartzheng.viewmodelapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.smartzheng.viewmodelapp.R
import com.smartzheng.viewmodelapp.model.entity.Subject

/**
 * Created by smartzheng
 * 2019/3/28
 */
class MovieAdapter(val movies: MutableList<Subject>) : RecyclerView.Adapter<MovieAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewHolder {
        val viewDataBinding = DataBindingUtil.inflate<com.smartzheng.viewmodelapp.databinding.AdapterMovieBinding>(
            LayoutInflater.from(p0.context),
            R.layout.adapter_movie,
            p0,
            false
        )
        return RecyclerViewHolder(viewDataBinding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(p0: RecyclerViewHolder, p1: Int) {
        p0.dataBinding?.setVariable(com.smartzheng.viewmodelapp.BR.subject, movies[p1])
        p0.dataBinding?.executePendingBindings()
    }

    fun addMovie(movies: MutableList<Subject>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    class RecyclerViewHolder(viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {
        var dataBinding: ViewDataBinding? = viewDataBinding
    }
}