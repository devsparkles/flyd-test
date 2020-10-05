package com.devsparkle.flydapp.presentation.features.album

import com.devsparkle.flydapp.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface AlbumComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AlbumComponent
    }

    // Classes that can be injected by this component
    fun inject(activity: AlbumActivity)
}
