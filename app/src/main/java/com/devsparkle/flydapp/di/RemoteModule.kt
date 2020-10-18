package com.devsparkle.flydapp.di

import com.devsparkle.flydapp.BuildConfig
import com.devsparkle.flydapp.data.remote.TokenInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
open class RemoteModule {

    @Provides
    @Singleton
    fun provideTokenInterceptor(): TokenInterceptor {
        return TokenInterceptor()
    }

    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        // debug interceptor like Stetho and http logging interceptor
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(logging)
            okHttpBuilder.addNetworkInterceptor(StethoInterceptor())
        }
        return okHttpBuilder.apply {
            readTimeout(5, TimeUnit.MINUTES)
            connectTimeout(5, TimeUnit.MINUTES)
            writeTimeout(5, TimeUnit.MINUTES)
            callTimeout(5, TimeUnit.MINUTES)
        }
    }

    @Provides
    fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create()) // to allow to get or post scalar type like String for example directly
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    fun provideBaseRetrofit(
        retrofitBuilder: Retrofit.Builder, client: OkHttpClient.Builder,
        tokenInterceptor: TokenInterceptor
    ): Retrofit {
        client.addInterceptor(tokenInterceptor)
        return retrofitBuilder
            .client(client.build())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
}