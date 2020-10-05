package com.devsparkle.flydapp.data.local.shared

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date
abstract class BaseEntity : Serializable {

    @ColumnInfo(name = "description")
    @SerializedName(value = "description")
    var description: String? = null

    @ColumnInfo(name = "creation_date")
    @SerializedName(value = "creation_date")
    var creationDate: Date = Date(System.currentTimeMillis())

    @ColumnInfo(name = "modification_date")
    @SerializedName(value = "modification_date")
    var modificationDate: Date = Date(System.currentTimeMillis())
}
