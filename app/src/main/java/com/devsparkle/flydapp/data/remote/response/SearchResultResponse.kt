package com.devsparkle.flydapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class SearchResultResponse(
    @SerializedName("pagination") var pagination: PaginationResponse?,
    @SerializedName("results") var results: List<ResultResponse>?,
)