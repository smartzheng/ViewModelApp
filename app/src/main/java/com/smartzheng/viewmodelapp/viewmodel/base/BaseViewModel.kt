package com.smartzheng.viewmodelapp.viewmodel.base

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModel

/**
 * Created by smartzheng
 * 2019/4/4
 */
abstract class BaseViewModel(private val context: Context, private val arguments: Bundle?): ViewModel()