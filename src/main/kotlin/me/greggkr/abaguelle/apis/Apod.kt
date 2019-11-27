package me.greggkr.abaguelle.apis

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import me.greggkr.abaguelle.util.addQueryParameter
import me.greggkr.kdbf.config
import okhttp3.OkHttpClient
import okhttp3.Request

private const val URL = "https://api.nasa.gov/planetary/apod"
private val client =
    OkHttpClient.Builder()
        .addQueryParameter("api_key", config.getOrDefault("nasa_key", "DEMO_KEY") as String)
        .build()

data class ApodResponse(
    @SerializedName("copyright") val copyright: String,
    @SerializedName("date") val date: String,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("hdurl") val hdUrl: String,
    @SerializedName("media_type") val mediaType: String,
    @SerializedName("service_version") val serviceVersion: String,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String
)

fun getApod(): ApodResponse? {
    val req = client.newCall(
        Request.Builder()
            .url(URL)
            .get()
            .build()
    ).execute()

    val res = req.body?.string() ?: return null
    return Gson().fromJson(res, ApodResponse::class.java)
}