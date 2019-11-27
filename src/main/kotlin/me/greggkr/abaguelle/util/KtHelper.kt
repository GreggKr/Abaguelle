package me.greggkr.abaguelle.util

import okhttp3.OkHttpClient

fun OkHttpClient.Builder.addQueryParameter(name: String, value: String): OkHttpClient.Builder {
    return this.addInterceptor {
        it.proceed(
            it.request().newBuilder().url(
                it.request().url.newBuilder()
                    .addQueryParameter(name, value)
                    .build()
            ).build()
        )
    }
}