package com.huseyinbulbul.spacex.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.huseyinbulbul.spacex.R
import com.huseyinbulbul.spacex.model.Flight
import com.huseyinbulbul.spacex.presenter.MainPresenter
import kotlinx.android.synthetic.main.item_flight.view.*

class MainAdapter(var presenter: MainPresenter, var items: List<Flight>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_flight, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val flight = items.get(position)

        Glide.with(holder.itemView)
                .load(flight.links.image)
                .into(holder.itemView.iv_image)

        holder.itemView.tv_name.text = flight.name
        holder.itemView.tv_info.text = String.format(holder.itemView.resources.getString(R.string.fligh_info), flight.year, flight.launcSite.name)
        if(flight.success) {
            holder.itemView.iv_success.setImageResource(R.drawable.ic_action_success)
        }else {
            holder.itemView.iv_success.setImageResource(R.drawable.ic_action_warning)
        }

        holder.itemView.setOnClickListener {
            presenter.flightSelected(position)
        }
    }


    class MainViewHolder(view: View): RecyclerView.ViewHolder(view)
}