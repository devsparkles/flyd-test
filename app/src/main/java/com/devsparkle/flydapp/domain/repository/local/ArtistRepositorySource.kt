package com.devsparkle.flydapp.domain.repository.local

import com.devsparkle.flydapp.domain.dto.ArtistDTO
import io.reactivex.Flowable

interface ArtistRepositorySource {
    fun getArtist(): Flowable<List<ArtistDTO>>
    fun searchArtist(name: String): Flowable<List<ArtistDTO>>
}
