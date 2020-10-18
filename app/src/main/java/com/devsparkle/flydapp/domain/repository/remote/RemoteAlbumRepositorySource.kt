package com.devsparkle.flydapp.domain.repository.remote

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import io.reactivex.Single

interface RemoteAlbumRepositorySource {
    fun getAlbumsByName(name: String): Single<List<AlbumDTO>>
}
