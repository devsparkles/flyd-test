package com.devsparkle.flydapp.data.repository.remote

import com.devsparkle.flydapp.data.Resource
import com.devsparkle.flydapp.domain.dto.ArtistDTO
import com.devsparkle.flydapp.domain.repository.remote.RemoteArtistRepositorySource
import io.reactivex.Single
import javax.inject.Inject

class RemoteArtistRepository @Inject constructor() : RemoteArtistRepositorySource {

    override fun requestArtistByRelease(name: String): Single<Resource<ArtistDTO>> {
        TODO("Not yet implemented")
    }

    override fun requestAtistsByRelease(name: String): Single<Resource<List<ArtistDTO>>> {
        TODO("Not yet implemented")
    }
}
