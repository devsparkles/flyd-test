package com.devsparkle.flydapp.domain.repository.remote

import com.devsparkle.flydapp.data.Resource
import com.devsparkle.flydapp.domain.dto.ArtistDTO
import io.reactivex.rxjava3.core.Single

interface RemoteArtistRepositorySource {
    fun requestArtistByRelease(name: String): Single<Resource<ArtistDTO>>
    fun requestAtistsByRelease(name: String): Single<Resource<List<ArtistDTO>>>
}
