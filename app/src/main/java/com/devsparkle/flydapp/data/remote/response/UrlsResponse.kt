package com.devsparkle.flydapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class UrlsResponse (
    @SerializedName("last") var last: String?,
    @SerializedName("next") var next: String?,
){
}