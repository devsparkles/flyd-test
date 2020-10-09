package com.devsparkle.flydapp.domain.repository.remote

import com.bumptech.glide.load.engine.Resource
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import io.reactivex.rxjava3.core.Single

interface RemoteAlbumRepositorySource {
    fun getAlbumsByName(name: String): Single<List<AlbumDTO>>
}
