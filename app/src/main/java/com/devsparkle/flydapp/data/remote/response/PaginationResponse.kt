package com.devsparkle.flydapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class PaginationResponse(
    @SerializedName("page") var page: String?,
    @SerializedName("pages") var pages: String?,
    @SerializedName("per_page") var perPage: String?,
    @SerializedName("items") var items: String?,
    @SerializedName("urls") var urls: UrlsResponse?,
)