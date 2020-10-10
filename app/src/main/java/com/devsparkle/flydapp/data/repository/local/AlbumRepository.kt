package com.devsparkle.flydapp.data.repository.local

import com.devsparkle.flydapp.data.local.FlydDatabase
import com.devsparkle.flydapp.data.mapper.FromDTOtoEntity
import com.devsparkle.flydapp.data.mapper.FromEntityToDTO
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.repository.local.AlbumRepositorySource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private var db: FlydDatabase,
    private var mapper: FromEntityToDTO,
    private var mapper2: FromDTOtoEntity
) : AlbumRepositorySource {

    override fun getAlbums(): Flowable<List<AlbumDTO>> {
        return db.albumDao().getAlbums()
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


    override fun getAlbumsByName(name: String): Flowable<List<AlbumDTO>> {
        return db.albumDao().getAlbumsByName(name)
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

    override fun saveAlbums(albums: List<AlbumDTO>): Completable {
        return Completable.defer {
            db.albumDao().insertAll(mapper2.albumDTOtoEntityAll(albums))
            Completable.complete()
        }
    }

    override fun deleteAlbums(): Completable {
        return Completable.defer {
            db.albumDao().delete()
            Completable.complete()
        }
    }

}