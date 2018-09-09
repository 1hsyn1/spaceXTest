package com.huseyinbulbul.spacex.model.manager

import com.huseyinbulbul.spacex.common.network.ApiConnector
import com.huseyinbulbul.spacex.model.Flight
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class FlightManager {
    companion object {
        private var instance: FlightManager? = null

        fun getInstance():FlightManager {
            if(instance == null){
                instance = FlightManager()
            }
            return instance as FlightManager
        }
    }

    private lateinit var flights: List<Flight>
    var selectedIndex = -1

    constructor(){
        flights = listOf(Flight())
    }

    fun getFlights(year: String, descendingOrder: Boolean, subscriber: Subscriber<List<Flight>>) {
        var order = "desc"
        if (!descendingOrder)
            order = "asc"
        ApiConnector.getApi().getFlights(year, order)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<List<Flight>>() {
                    override fun onNext(t: List<Flight>) {
                        flights = t
                        subscriber.onNext(t)
                    }

                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {
                        subscriber.onError(e)
                    }

                })
    }

    fun getSelectedFlight():Flight? {
        if(selectedIndex < 0 || selectedIndex >= flights.size){
            return null
        }
        return flights.get(selectedIndex)
    }
}