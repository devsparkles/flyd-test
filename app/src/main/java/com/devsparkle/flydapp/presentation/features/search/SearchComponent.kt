package com.devsparkle.flydapp.presentation.features.search

import com.devsparkle.flydapp.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SearchComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SearchComponent
    }

    // Classes that can be injected by this component
    fun inject(activity: SearchActivity)
}
