package me.greggkr.abaguelle.util

import okhttp3.OkHttpClient

class Tuple(val key: String, val value: String)

fun OkHttpClient.Builder.addQueryParameters(vararg params: Tuple): OkHttpClient.Builder {
    return this.addInterceptor {
        val b = it.request().url.newBuilder()
        for (p in params) {
            b.addQueryParameter(p.key, p.value)
        }

        it.proceed(it.request().newBuilder().url(b.build()).build())
    }
}