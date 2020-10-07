package com.devsparkle.flydapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResultResponse(

    @SerializedName("country") var country: String?,
    @SerializedName("year") var year: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("cover_image") var coverImage: String?,
    @SerializedName("resource_url") var resourceUrl: String?,

){

}