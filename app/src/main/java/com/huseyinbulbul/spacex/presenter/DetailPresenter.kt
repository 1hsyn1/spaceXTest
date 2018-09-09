package com.huseyinbulbul.spacex.presenter

import com.huseyinbulbul.spacex.model.manager.FlightManager
import com.huseyinbulbul.spacex.presenter.iview.IBaseView
import com.huseyinbulbul.spacex.presenter.iview.IDetailView

class DetailPresenter private constructor(var view: IDetailView){
    companion object {
        private var instance: DetailPresenter? = null

        fun getInstance(view: IDetailView): DetailPresenter{
            if (instance == null){
                instance = DetailPresenter(view)
            }else {
                instance!!.view = view
            }
            return instance as DetailPresenter
        }
    }

    fun onCreate(){
        if(FlightManager.getInstance().getSelectedFlight() == null) {
            view.showNoFlight()
        }else {
            view.showFlight(FlightManager.getInstance().getSelectedFlight()!!)
        }
    }
}