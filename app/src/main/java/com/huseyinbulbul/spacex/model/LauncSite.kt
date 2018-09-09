package com.huseyinbulbul.spacex.model

import com.google.gson.annotations.SerializedName

class LauncSite {
    @SerializedName ("site_name")
    lateinit var name: String
    @SerializedName ("site_name_long")
    lateinit var description: String
}