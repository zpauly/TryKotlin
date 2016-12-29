package com.zpauly.firstkotlinapp.net

import android.util.Log
import com.zpauly.firstkotlinapp.entities.Data
import com.zpauly.trykotlin.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by zpauly on 2016/12/28.
 */
class Apis {
    companion object {
        private val clientBuilder: OkHttpClient.Builder

        private val services: Services

        val interceptor = Interceptor { chain ->
            chain?.let {
                Log.i("intercept", "${chain.request().url()}")
            }
            chain!!.proceed(chain.request())
        }

        init {
            clientBuilder = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .followRedirects(true)
                    .followSslRedirects(true)

            val retrofit = Retrofit.Builder()
                    .client(clientBuilder.build())
                    .baseUrl(Constants.API)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            services = retrofit.create(Services::class.java)
        }
    }

    fun getFuliData(observer: Observer<Data>?, pageId: Int = 1): Subscription =
        services.getFuliData(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    fun getAndroidData(observer: Observer<Data>?, pageId: Int = 1): Subscription =
        services.getAndroidData(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    fun getIOSData(observer: Observer<Data>?, pageId: Int = 1): Subscription =
        services.getIOSData(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    fun getXiuxishipinData(observer: Observer<Data>?, pageId: Int = 1): Subscription =
        services.getXiuxishipinData(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    fun getTuozhanziyuanData(observer: Observer<Data>?, pageId: Int = 1): Subscription =
        services.getTuozhanziyuanData(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    fun getQianduanData(observer: Observer<Data>?, pageId: Int = 1): Subscription =
        services.getQianduanData(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    fun getAllData(observer: Observer<Data>?, pageId: Int = 1): Subscription =
        services.getAllData(pageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
}