package com.example.androiddemo.network
import com.example.androiddemo.network.FiguresApiClient.retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FiguresApiClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()

            val newRequest = request.newBuilder()
                .addHeader("X-Api-Key", "mj4shvaJCDpIS5wpyEgosA==hrGmrA7aYkKLxXUP")
                .build()

            chain.proceed(newRequest)
        }
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private const val BASE_URL = "https://api.api-ninjas.com/v1/"

    val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    val instance = retrofit.create(FiguresApiService::class.java)
}