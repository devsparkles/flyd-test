package com.devsparkle.flydapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devsparkle.flydapp.presentation.features.album.AlbumViewModel
import com.devsparkle.flydapp.presentation.features.artist.ArtistViewModel
import com.devsparkle.flydapp.presentation.features.shared.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Since dagger
 * support multibinding you are free to bind as may ViewModels as you want.
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AlbumViewModel::class)
    abstract fun bindAlbumViewModel(viewModel: AlbumViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArtistViewModel::class)
    abstract fun bindArtistViewModel(viewModel: ArtistViewModel): ViewModel
}
