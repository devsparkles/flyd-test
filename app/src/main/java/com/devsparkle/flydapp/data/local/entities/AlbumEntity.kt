package com.devsparkle.flydapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devsparkle.flydapp.data.local.shared.BaseEntity

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
    var accessToken: String
) : BaseEntity()
