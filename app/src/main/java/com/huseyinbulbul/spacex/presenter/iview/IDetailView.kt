package com.huseyinbulbul.spacex.presenter.iview

import com.huseyinbulbul.spacex.model.Flight

interface IDetailView {
    fun showNoFlight()
    fun showFlight(flight: Flight)
}