package com.devsparkle.flydapp.data.repository.local

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.dto.ArtistDTO
import com.devsparkle.flydapp.domain.repository.local.AlbumRepositorySource
import com.devsparkle.flydapp.domain.repository.local.ArtistRepositorySource
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class ArtistRepository  @Inject constructor() : ArtistRepositorySource {
    override fun getArtist(): Flowable<List<ArtistDTO>> {
        TODO("Not yet implemented")
    }

    override fun searchArtist(name: String): Flowable<List<ArtistDTO>> {
        TODO("Not yet implemented")
    }
}