package com.devsparkle.flydapp.domain.usecases.album

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.repository.local.AlbumRepositorySource
import io.reactivex.Completable
import javax.inject.Inject

class SaveAlbumsUseCase @Inject constructor(
    private val local: AlbumRepositorySource
) {

    fun saveAlbum(albums: List<AlbumDTO>): Completable {
        return Completable.defer {
            local.deleteAlbums()
            local.persistAlbums(albums)
        }

    }
}