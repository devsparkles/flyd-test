package com.devsparkle.flydapp.domain.usecases.album

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.repository.local.AlbumRepositorySource
import com.devsparkle.flydapp.domain.repository.remote.RemoteAlbumRepositorySource
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val remote: RemoteAlbumRepositorySource,
    private val local: AlbumRepositorySource
) {

    fun loadAllAlbumsFromDB(): Flowable<List<AlbumDTO>> {
        return local.loadAlbums()
    }

    fun loadAllAlbumsByNameFromDB(name: String): Flowable<List<AlbumDTO>> {
        return local.loadAlbumsByName(name)
    }

    fun fetchAlbumListByNameRemote(name: String): Single<List<AlbumDTO>> {
        return remote.getAlbumsByName(name)
    }
}