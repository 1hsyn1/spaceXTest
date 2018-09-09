package com.huseyinbulbul.spacex.model

import com.google.gson.annotations.SerializedName

class Rocket {
    @SerializedName("rocket_name")
    lateinit var name: String
}