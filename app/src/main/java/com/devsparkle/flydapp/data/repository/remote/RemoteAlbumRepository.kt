package com.devsparkle.flydapp.data.repository.remote

import com.devsparkle.flydapp.data.mapper.FromResponseToDTO
import com.devsparkle.flydapp.data.remote.api.DiscogsServiceApi
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.repository.remote.RemoteAlbumRepositorySource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteAlbumRepository @Inject constructor(
    private var api: DiscogsServiceApi,
    private var mapper: FromResponseToDTO
) : RemoteAlbumRepositorySource {

    override fun getAlbumsByName(name: String): Single<List<AlbumDTO>> {
        return api.searchAlbumByName(name).map {
            mapper.albumResponseToDTO(it)
        }
    }
}
