package com.smartzheng.viewmodelapp.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val context: Context, private val arguments: Bundle?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val params = arrayOf<Class<*>>(Context::class.java, Bundle::class.java)
        Log.d("modelClass.constructors", modelClass.constructors.toString())
        return modelClass.getConstructor(params[0], params[1]).newInstance(context, arguments)
    }

}
