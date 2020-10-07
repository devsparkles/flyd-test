package com.devsparkle.flydapp

import android.app.Application
import android.content.Context
import com.devsparkle.flydapp.di.AppComponent
import com.devsparkle.flydapp.di.DaggerAppComponent

class FlydApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()!!
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    fun initializeComponent(): AppComponent? {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph

        return DaggerAppComponent.factory().create(applicationContext)
    }

    companion object {
        lateinit var context: Context
    }
}
