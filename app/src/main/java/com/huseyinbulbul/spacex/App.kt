package com.huseyinbulbul.spacex

import android.app.Application

class App: Application() {
    companion object {
        public lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}