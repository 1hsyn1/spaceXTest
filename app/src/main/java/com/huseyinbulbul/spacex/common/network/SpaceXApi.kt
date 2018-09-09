package com.huseyinbulbul.spacex.common.network

import com.huseyinbulbul.spacex.model.Flight
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface SpaceXApi {
    @GET("v2/launches")
    fun getFlights(@Query("launch_year") year: String, @Query("order") order: String): Observable<List<Flight>>
}