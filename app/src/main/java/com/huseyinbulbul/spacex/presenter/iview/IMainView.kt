package com.huseyinbulbul.spacex.presenter.iview

import com.huseyinbulbul.spacex.model.Flight

interface IMainView: IBaseView {
    fun showFlights(flights: List<Flight>)
    fun showEmptyView()
    fun showErrorView()
}