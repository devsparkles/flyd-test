package com.devsparkle.flydapp.data.repository.local

import com.devsparkle.flydapp.domain.dto.ArtistDTO
import com.devsparkle.flydapp.domain.repository.local.ArtistRepositorySource
import io.reactivex.Flowable
import javax.inject.Inject

class ArtistRepository @Inject constructor() : ArtistRepositorySource {
    override fun getArtist(): Flowable<List<ArtistDTO>> {
        TODO("Not yet implemented")
    }

    override fun searchArtist(name: String): Flowable<List<ArtistDTO>> {
        TODO("Not yet implemented")
    }
}