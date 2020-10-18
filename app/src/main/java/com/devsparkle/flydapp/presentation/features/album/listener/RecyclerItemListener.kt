package com.devsparkle.flydapp.presentation.features.album.listener

import com.devsparkle.flydapp.domain.dto.AlbumDTO

interface RecyclerItemListener {
    fun onItemSelected(album: AlbumDTO)
}
