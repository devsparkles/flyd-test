package com.devsparkle.flydapp.di

import com.devsparkle.flydapp.data.repository.local.AlbumRepository
import com.devsparkle.flydapp.data.repository.local.ArtistRepository
import com.devsparkle.flydapp.data.repository.remote.RemoteAlbumRepository
import com.devsparkle.flydapp.data.repository.remote.RemoteArtistRepository
import com.devsparkle.flydapp.domain.repository.local.AlbumRepositorySource
import com.devsparkle.flydapp.domain.repository.local.ArtistRepositorySource
import com.devsparkle.flydapp.domain.repository.remote.RemoteAlbumRepositorySource
import com.devsparkle.flydapp.domain.repository.remote.RemoteArtistRepositorySource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

// Tells Dagger this is a Dagger module
@Module
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideRemoteAlbumRepository(dataRepository: RemoteAlbumRepository): RemoteAlbumRepositorySource

    @Binds
    @Singleton
    abstract fun provideRemoteArtistRepository(dataRepository: RemoteArtistRepository): RemoteArtistRepositorySource

    @Binds
    @Singleton
    abstract fun provideAlbumRepository(dataRepository: AlbumRepository): AlbumRepositorySource

    @Binds
    @Singleton
    abstract fun provideArtistRepository(dataRepository: ArtistRepository): ArtistRepositorySource
}
