package com.devsparkle.flydapp.domain.dto

data class AlbumDTO(
    var title: String,
    var imageUrl: String,
    var tracks: List<TrackDTO>,
    var year: String
)