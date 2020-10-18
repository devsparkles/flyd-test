package com.devsparkle.flydapp.di

import android.app.Application
import com.devsparkle.flydapp.FlydApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        RemoteModule::class,
        ActivityModuleBuilder::class, ViewModelModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: FlydApplication)
}
