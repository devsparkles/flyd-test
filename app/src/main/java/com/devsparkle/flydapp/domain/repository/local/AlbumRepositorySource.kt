package com.devsparkle.flydapp.domain.repository.local

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface AlbumRepositorySource {


    fun getAlbums(): Flowable<List<AlbumDTO>>


    /**
     * Get album from the local database,via observable,
     * every insert,delete, or update will fire
     * a select via trigger installed on the sqlite database
     */
    fun getAlbumsByName(name: String): Flowable<List<AlbumDTO>>

    /**
     * Save list of album
     */
    fun saveAlbums(albums: List<AlbumDTO>): Completable


    /**
     * Delete album
     */
    fun deleteAlbums(): Completable
}
