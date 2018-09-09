package com.huseyinbulbul.spacex.presenter

import com.huseyinbulbul.spacex.R
import com.huseyinbulbul.spacex.model.Flight
import com.huseyinbulbul.spacex.model.manager.FlightManager
import com.huseyinbulbul.spacex.presenter.iview.IMainView
import com.huseyinbulbul.spacex.view.DetailActivity
import rx.Subscriber

class MainPresenter private constructor(var view: IMainView){
    companion object {
        private var instance: MainPresenter? = null

        fun getInstance(view: IMainView):MainPresenter {
            if(instance == null) {
                instance = MainPresenter(view)
            }else {
                instance!!.view = view
            }
            return instance as MainPresenter
        }
    }

    fun onCreate(){
        view.showLoading()
        FlightManager.getInstance().getFlights("",true, object: Subscriber<List<Flight>>(){
            override fun onNext(t: List<Flight>) {
                if(t.isNotEmpty()) {
                    view.showFlights(t)
                }else {
                    view.showEmptyView()
                }
                view.hideLoading()
            }

            override fun onCompleted() {

            }

            override fun onError(e: Throwable?) {
                view.showErrorView()
                view.hideLoading()
            }

        })
    }

    fun flightSelected(position: Int){
        FlightManager.getInstance().selectedIndex = position
        view.openActivity(DetailActivity::class.java)
    }
}