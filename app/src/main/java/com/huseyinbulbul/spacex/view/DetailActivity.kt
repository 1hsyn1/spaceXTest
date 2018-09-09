package com.huseyinbulbul.spacex.view

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.huseyinbulbul.spacex.R
import com.huseyinbulbul.spacex.common.view.BaseViewActivity
import com.huseyinbulbul.spacex.model.Flight
import com.huseyinbulbul.spacex.presenter.DetailPresenter
import com.huseyinbulbul.spacex.presenter.iview.IDetailView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseViewActivity(), IDetailView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val presenter: DetailPresenter = DetailPresenter.getInstance(this)
        presenter.onCreate()
    }

    override fun showNoFlight() {
        cl_content.visibility = View.GONE
        tv_error.visibility = View.VISIBLE
    }

    override fun showFlight(flight: Flight) {
        tv_name.text = flight.name
        tv_year.text = flight.year
        tv_launch.text = String.format(resources.getString(R.string.launched), flight.launcSite.description)
        tv_description.text = flight.details

        if(flight.success) {
            iv_success.setImageResource(R.drawable.ic_action_success)
        }else {
            iv_success.setImageResource(R.drawable.ic_action_warning)
        }

        Glide.with(this)
                .load(flight.links.image)
                .into(iv_image)

        tv_error.visibility = View.GONE
    }
}
