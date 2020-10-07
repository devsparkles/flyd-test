package com.devsparkle.flydapp.domain.usecases.search

import com.devsparkle.flydapp.domain.dto.AlbumDTO
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchAlbumUseCase @Inject constructor(val searchRemoteRepository: ISearchRemoteRepository) {

    fun search(release: String) : Single<List<AlbumDTO>> {
        return
    }
}
