package com.zpauly.firstkotlinapp.net

import com.zpauly.firstkotlinapp.entities.Data
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by zpauly on 2016/12/28.
 */
interface Services {
    @GET("/api/data/福利/15/{pageId}")
    fun getFuliData(@Path("pageId") pageId: Int): Observable<Data>

    @GET("/api/data/Android/15/{pageId}")
    fun getAndroidData(@Path("pageId") pageId: Int): Observable<Data>

    @GET("/api/data/iOS/15/{pageId}")
    fun getIOSData(@Path("pageId") pageId: Int): Observable<Data>

    @GET("/api/data/休息视频/15/{pageId}")
    fun getXiuxishipinData(@Path("pageId") pageId: Int): Observable<Data>

    @GET("/api/data/拓展资源/15/{pageId}")
    fun getTuozhanziyuanData(@Path("pageId") pageId: Int): Observable<Data>

    @GET("/api/data/前端/15/{pageId}")
    fun getQianduanData(@Path("pageId") pageId: Int): Observable<Data>

    @GET("/api/data/all/15/{pageId}")
    fun getAllData(@Path("pageId") pageId: Int): Observable<Data>
}