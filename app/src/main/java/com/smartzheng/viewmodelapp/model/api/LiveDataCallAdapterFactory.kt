package com.smartzheng.viewmodelapp.model.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by smartzheng
 * 2019/3/28
 */
class LiveDataCallAdapterFactory : CallAdapter.Factory() {
    /**
     * 返回 LiveData<?>
     */
    override fun get(returnType: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): CallAdapter<*, *>? {
        if (returnType !is ParameterizedType) {
            throw IllegalArgumentException("返回值需为参数化类型")
        }
        val returnClass = CallAdapter.Factory.getRawType(returnType)
        if (returnClass != MutableLiveData::class.java) {
            throw IllegalArgumentException("返回值不是LiveData类型")
        }
        val type = CallAdapter.Factory.getParameterUpperBound(0, returnType)
        return LiveDataCallAdapter<Any>(type)
    }

    /**
     * 请求适配器
     */
    class LiveDataCallAdapter<R>(private var type: Type) : CallAdapter<R, MutableLiveData<R>> {
        override fun adapt(call: Call<R>?): MutableLiveData<R> {
            return object : MutableLiveData<R>() {
                //这个作用是业务在多线程中,业务处理的线程安全问题,确保单一线程作业
                val flag = AtomicBoolean(false)

                override fun onActive() {
                    super.onActive()
                    if (flag.compareAndSet(false, true)) {
                        call!!.enqueue(object : Callback<R> {
                            override fun onFailure(call: Call<R>?, t: Throwable?) {
                                postValue(null)
                            }

                            override fun onResponse(call: Call<R>?, response: Response<R>?) {
                                Log.d("response", response?.body().toString())
                                postValue(response?.body())
                            }
                        })
                    }
                }
            }
        }

        override fun responseType(): Type {
            return type
        }
    }
}