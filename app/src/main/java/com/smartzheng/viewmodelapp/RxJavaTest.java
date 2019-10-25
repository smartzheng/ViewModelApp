package com.smartzheng.viewmodelapp;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by smartzheng
 * 2019-05-05
 */
public class RxJavaTest {

    public static final String TAG = "RxJavaTest";

    public static void main(String[] args) {
        rxJavaTest();
    }

    private static void rxJavaTest() {
        Observable
                .just("1", "2")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer i) {
                        Log.d(TAG, i.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }
}
