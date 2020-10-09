package com.devsparkle.flydapp.di

import com.devsparkle.flydapp.presentation.features.album.AlbumActivity
import com.devsparkle.flydapp.presentation.features.artist.ArtistActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector()
    abstract fun contributeSplashActivity(): AlbumActivity

    @ContributesAndroidInjector()
    abstract fun contributeHomeActivity(): ArtistActivity
}
