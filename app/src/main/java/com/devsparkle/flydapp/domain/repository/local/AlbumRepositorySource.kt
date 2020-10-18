package com.devsparkle.flydapp.domain.repository.local

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import io.reactivex.Completable
import io.reactivex.Flowable

interface AlbumRepositorySource {

    fun loadAlbums(): Flowable<List<AlbumDTO>>

    /**
     * Get album from the local database,via observable,
     * every insert,delete, or update will fire
     * a select via trigger installed on the sqlite database
     */
    fun loadAlbumsByName(name: String): Flowable<List<AlbumDTO>>

    /**
     * Save list of album
     */
    fun persistAlbums(albums: List<AlbumDTO>): Completable

    /**
     * Delete album
     */
    fun deleteAlbums()
}
