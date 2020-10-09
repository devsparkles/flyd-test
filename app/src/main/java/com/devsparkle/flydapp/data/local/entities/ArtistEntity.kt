package com.devsparkle.flydapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devsparkle.flydapp.data.local.shared.BaseEntity

@Entity(tableName = "artists")
data class ArtistEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
    var name: String,
    var age: String,
    var imageUrl: String
) : BaseEntity()
