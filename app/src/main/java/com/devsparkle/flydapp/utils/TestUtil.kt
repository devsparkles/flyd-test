package com.devsparkle.flydapp.utils

import com.devsparkle.flydapp.data.local.entities.AlbumEntity

object TestUtil {

    fun createAlbum(id: Long) = AlbumEntity(
        id = id,

        title = "",
        country = "",
        year = "",
        coverImageUrl = "",
        resourceUrl = "",

        artist = "",
        summary = ""
    )

    fun makeAlbumList(size: Int): MutableList<AlbumEntity> {
        val list = ArrayList<AlbumEntity>(size)
        list.forEach {
            it.title = "Photo ${list.indexOf(it)}"
            it.id = (list.indexOf(it) + 1).toLong()

            list.add(it)
        }
        return list
    }
}