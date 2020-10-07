package com.devsparkle.flydapp.di

import android.app.Application
import androidx.room.Room
import com.devsparkle.flydapp.BuildConfig
import com.devsparkle.flydapp.data.local.FlydDatabase
import com.devsparkle.flydapp.data.remote.TokenInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideLocalDatabase(application: Application): FlydDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            FlydDatabase::class.java, "flyd.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
    }

    @Provides
    @Singleton
    @Named("keySecretHeader")
    fun provideAuthHeaderInterceptorInterceptor(): Interceptor = TokenInterceptor()

    @Provides
    @Singleton
    @Named("httpClientBuilder")
    fun provideOkHttpBuilder(@Named("keySecretHeader") keySecretHeader: Interceptor): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        // debug interceptor like Stetho and http logging interceptor
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(logging)
            okHttpBuilder.addNetworkInterceptor(StethoInterceptor())
        }
        // add the key and secret to acceess the api
        okHttpBuilder.addInterceptor(keySecretHeader)
        return okHttpBuilder.apply {
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
            callTimeout(10, TimeUnit.SECONDS)
        }
    }

    @Provides
    @Singleton
    @Named("retrofitBuilder")
    fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create()) // to allow to get or post scalar type like String for example directly
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    }

    @Provides
    @Singleton
    @Named("authenticationRetrofit")
    fun provideBaseRetrofit(
        @Named("retrofitBuilder") retrofitBuilder: Retrofit.Builder,
        @Named("httpClientBuilder") client: OkHttpClient.Builder,
        tokenInterceptor: TokenInterceptor
    ): Retrofit {
        client.addInterceptor(tokenInterceptor)
        return retrofitBuilder
            .client(client.build())
            .baseUrl("https://api.discogs.com/")
            .build()
    }
}
