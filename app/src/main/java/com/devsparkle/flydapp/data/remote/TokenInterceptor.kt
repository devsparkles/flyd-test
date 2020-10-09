package com.devsparkle.flydapp.data.remote

import com.devsparkle.flydapp.BuildConfig
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val key = BuildConfig.KEY
        val secret = BuildConfig.SECRET
        val request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Discogs key=$key, secret=$secret"
            )
            .build()
        return chain.proceed(request)
    }
}
