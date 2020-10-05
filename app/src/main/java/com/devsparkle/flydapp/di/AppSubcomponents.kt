package com.devsparkle.flydapp.di

import com.devsparkle.flydapp.presentation.features.album.AlbumComponent
import com.devsparkle.flydapp.presentation.features.artist.ArtistComponent
import com.devsparkle.flydapp.presentation.features.search.SearchComponent
import dagger.Module

@Module(
    subcomponents = [
        SearchComponent::class,
        ArtistComponent::class,
        AlbumComponent::class
    ]
)
class AppSubcomponents
