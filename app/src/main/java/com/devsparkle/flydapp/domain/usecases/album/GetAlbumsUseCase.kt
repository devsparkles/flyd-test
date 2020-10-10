package com.devsparkle.flydapp.domain.usecases.album

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.repository.local.AlbumRepositorySource
import com.devsparkle.flydapp.domain.repository.remote.RemoteAlbumRepositorySource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val remote: RemoteAlbumRepositorySource,
    private val local: AlbumRepositorySource
) {


    fun getAlbumList(): Flowable<List<AlbumDTO>> {
        return local.getAlbums()
    }


    fun getAlbumListByName(name: String): Flowable<List<AlbumDTO>> {
        return local.getAlbumsByName(name)
    }

    fun getAlbumListByNameRemote(name: String): Single<List<AlbumDTO>> {
        return remote.getAlbumsByName(name)
    }

    fun saveAlbum(albums: List<AlbumDTO>): Completable {
        return local.deleteAlbums().andThen {
            local.saveAlbums(albums)
        }
    }
}