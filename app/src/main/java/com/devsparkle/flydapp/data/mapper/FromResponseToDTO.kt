package com.devsparkle.flydapp.data.mapper

import com.devsparkle.flydapp.data.remote.response.SearchResultResponse
import com.devsparkle.flydapp.domain.dto.AlbumDTO

class FromResponseToDTO {

    fun albumResponseToDTO(s: SearchResultResponse): List<AlbumDTO> {
        val list = mutableListOf<AlbumDTO>()
        s.results?.forEach {
            val a = AlbumDTO(
                title = it.title,
                country = it.country,
                artist = "",
                coverImageUrl = it.coverImage,
                resourceUrl = it.resourceUrl,
                summary = "",
                year = it.year
            )
            list.add(a)
        }

        return list
    }
}