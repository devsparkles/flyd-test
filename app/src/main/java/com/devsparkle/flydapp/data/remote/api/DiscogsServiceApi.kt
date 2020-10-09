package com.devsparkle.flydapp.data.remote.api


import com.devsparkle.flydapp.data.remote.response.SearchResultResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscogsServiceApi {

    /***
     * Fetch the list of album by release in the api
     * @return
     */
    @GET("database/search&{?release}")
    fun searchAlbumByName(
        @Query("q") albumName: String
    ): Single<SearchResultResponse>
}