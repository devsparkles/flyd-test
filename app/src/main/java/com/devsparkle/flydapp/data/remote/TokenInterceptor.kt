package com.devsparkle.flydapp.data.remote

import com.devsparkle.flydapp.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.Response

@Singleton
class TokenInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val key = BuildConfig.KEY
        val secret = BuildConfig.SECRET
        val request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Discogs key=${key}, secret=${secret}"
            )
            .build()
        return chain.proceed(request)
    }
}
