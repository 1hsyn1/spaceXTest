package com.huseyinbulbul.spacex.model

import com.google.gson.annotations.SerializedName

class Flight {
    @SerializedName("mission_name")
    lateinit var name: String
    @SerializedName("launch_year")
    lateinit var year: String
    @SerializedName("rocket")
    lateinit var rocket: Rocket
    @SerializedName("ships")
    lateinit var ships: List<String>
    @SerializedName("launch_site")
    lateinit var launcSite: LauncSite
    @SerializedName("launch_success")
    var success: Boolean = true
    @SerializedName("links")
    lateinit var links: Links
    @SerializedName("details")
    lateinit var details: String

}