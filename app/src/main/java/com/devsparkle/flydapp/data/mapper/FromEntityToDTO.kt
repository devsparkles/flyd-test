package com.devsparkle.flydapp.data.mapper

import com.devsparkle.flydapp.data.local.entities.AlbumEntity
import com.devsparkle.flydapp.domain.dto.AlbumDTO

class FromEntityToDTO {

    fun albumEntityToDTO(a: AlbumEntity): AlbumDTO {
        return AlbumDTO(
            title = a.title,
            country = a.country,
            year = a.year,
            coverImageUrl = a.coverImageUrl,
            resourceUrl = a.resourceUrl,

            artist = a.artist,
            summary = a.summary

        )
    }
}