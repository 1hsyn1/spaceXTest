package com.huseyinbulbul.spacex.common.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnector {
    companion object {
        fun getApi(): SpaceXApi {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(logger)

            var restAdapter = Retrofit.Builder()
                    .client(client.build())
                    .baseUrl("https://api.spacexdata.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

            return restAdapter.build().create(SpaceXApi::class.java)
        }
    }
}