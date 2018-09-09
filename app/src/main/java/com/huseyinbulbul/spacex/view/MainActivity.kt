package com.huseyinbulbul.spacex.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.huseyinbulbul.spacex.R
import com.huseyinbulbul.spacex.common.view.BaseViewActivity
import com.huseyinbulbul.spacex.model.Flight
import com.huseyinbulbul.spacex.presenter.MainPresenter
import com.huseyinbulbul.spacex.presenter.iview.IMainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseViewActivity(), IMainView {
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter.getInstance(this)

        rv_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        presenter.onCreate()
    }

    override fun showFlights(flights: List<Flight>) {
        rv_list.adapter = MainAdapter(presenter, flights)
        tv_error.visibility = View.GONE
        rv_list.visibility = View.VISIBLE
    }

    override fun showEmptyView() {
        tv_error.setText(R.string.no_flights)
        rv_list.visibility = View.GONE
        tv_error.visibility = View.VISIBLE
    }

    override fun showErrorView() {
        tv_error.setText(R.string.general_error)
        rv_list.visibility = View.GONE
        tv_error.visibility = View.VISIBLE
    }
}
