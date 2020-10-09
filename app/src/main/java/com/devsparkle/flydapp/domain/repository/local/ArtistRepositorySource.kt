package com.devsparkle.flydapp.domain.repository.local

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.dto.ArtistDTO
import io.reactivex.rxjava3.core.Flowable

interface ArtistRepositorySource {
    fun getArtist(): Flowable<List<ArtistDTO>>
    fun searchArtist(name: String): Flowable<List<ArtistDTO>>
}
