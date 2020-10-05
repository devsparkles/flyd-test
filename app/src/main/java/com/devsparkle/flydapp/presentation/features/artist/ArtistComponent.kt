package com.devsparkle.flydapp.presentation.features.artist

import com.devsparkle.flydapp.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ArtistComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistComponent
    }

    // Classes that can be injected by this component
    fun inject(activity: ArtistActivity)
}
