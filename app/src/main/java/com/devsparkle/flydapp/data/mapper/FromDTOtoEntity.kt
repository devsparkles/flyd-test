package com.devsparkle.flydapp.data.mapper

import com.devsparkle.flydapp.data.local.entities.AlbumEntity
import com.devsparkle.flydapp.domain.dto.AlbumDTO

class FromDTOtoEntity {

    fun albumDTOtoEntity(it: AlbumDTO): AlbumEntity {
        return AlbumEntity(
            id = 0L,
            title = it.title,
            country = it.country,
            artist = "",
            coverImageUrl = it.coverImageUrl,
            resourceUrl = it.resourceUrl,
            summary = "",
            year = it.year
        )
    }

    fun albumDTOtoEntityAll(albums: List<AlbumDTO>): List<AlbumEntity> {
        val list = mutableListOf<AlbumEntity>()
        albums.forEach { it ->
            list.add(
                AlbumEntity(
                    id = 0L,
                    title = it.title,
                    country = it.country,
                    artist = "",
                    coverImageUrl = it.coverImageUrl,
                    resourceUrl = it.resourceUrl,
                    summary = "",
                    year = it.year
                )
            )
        }

        return list
    }
}