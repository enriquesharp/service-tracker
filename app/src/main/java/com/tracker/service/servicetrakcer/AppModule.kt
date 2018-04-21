package com.tracker.service.servicetrakcer

import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tracker.service.servicetrakcer.data.local.LocalDataSource
import com.urbamap.urbamap.data.remote.RemoteAPIContract
import com.urbamap.urbamap.data.remote.RemoteAPIServiceInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.module.AndroidModule
import org.koin.dsl.context.Context
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppModule : AndroidModule() {
    override fun context(): Context = applicationContext {
        provide { provideRemoteAPIServiceInterface(get()) }
        provide { provideLocalDataSource(androidApplication.applicationContext) }
        provide { provideGSON() }
        provide { provideOkHttp() }
        provide { provideRetrofit(get(), get()) }
        provide { PreferenceManager.getDefaultSharedPreferences(androidApplication) }
    }

    private fun provideLocalDataSource(context: android.content.Context) = LocalDataSource.buildPersistentInstance(context)

    //Retrofit
    private fun provideRemoteAPIServiceInterface(retrofit: Retrofit): RemoteAPIServiceInterface = retrofit.create(RemoteAPIServiceInterface::class.java)

    private fun provideGSON(): Gson = GsonBuilder().setLenient().create()

    private fun provideOkHttp(): OkHttpClient {
        val okHttp = OkHttpClient.Builder()
        okHttp.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        okHttp.readTimeout(30, TimeUnit.SECONDS)
        okHttp.writeTimeout(20, TimeUnit.SECONDS)
        okHttp.connectTimeout(20, TimeUnit.SECONDS)
        return okHttp.build()
    }

    private fun provideRetrofit(gson: Gson, ok: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(RemoteAPIContract.BASE_URl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(ok)
            .build()

}