package com.devsparkle.flydapp

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.devsparkle.flydapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class FlydApplication : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        context = applicationContext
        initDagger()
    }

    open fun initDagger() {
        DaggerAppComponent.builder().application(this).build().inject(this)
        ///DaggerAppComponent.builder().build().inject(this)
    }

    companion object {
        lateinit var context: Context
    }
}
