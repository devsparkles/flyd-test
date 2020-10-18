package com.devsparkle.flydapp.data.repository.local

import com.devsparkle.flydapp.data.local.FlydDatabase
import com.devsparkle.flydapp.data.mapper.FromDTOtoEntity
import com.devsparkle.flydapp.data.mapper.FromEntityToDTO
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.repository.local.AlbumRepositorySource
import io.reactivex.Completable
import io.reactivex.Flowable

import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private var db: FlydDatabase,
    private var mapper: FromEntityToDTO,
    private var mapper2: FromDTOtoEntity
) : AlbumRepositorySource {

    override fun loadAlbums(): Flowable<List<AlbumDTO>> {
        return db.albumDao().loadAllAlbums()
            .map { albumList ->
                if (albumList.isEmpty()) {
                    emptyList()
                } else {
                    albumList.map {
                        mapper.albumEntityToDTO(it)
                    }
                }
            }
    }

    override fun loadAlbumsByName(name: String): Flowable<List<AlbumDTO>> {
        return db.albumDao().loadAlbumsByName(name = "%$name%")
            .map { albumList ->
                if (albumList.isEmpty()) {
                    emptyList()
                } else {
                    albumList.map {
                        mapper.albumEntityToDTO(it)
                    }
                }
            }
    }

    override fun persistAlbums(albums: List<AlbumDTO>): Completable {
        return db.albumDao().insertAll(mapper2.albumDTOtoEntityAll(albums))
    }

    override fun deleteAlbums() {
        return db.albumDao().deleteAll()
    }
}