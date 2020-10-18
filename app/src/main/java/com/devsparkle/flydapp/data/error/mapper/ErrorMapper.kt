package com.devsparkle.flydapp.data.error.mapper

import com.devsparkle.flydapp.FlydApplication
import com.devsparkle.flydapp.R
import com.devsparkle.flydapp.data.error.NETWORK_ERROR
import com.devsparkle.flydapp.data.error.NO_INTERNET_CONNECTION
import com.devsparkle.flydapp.data.error.SEARCH_ERROR

import javax.inject.Inject

class ErrorMapper @Inject constructor() : ErrorMapperInterface {

    override fun getErrorString(errorId: Int): String {
        return FlydApplication.context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getErrorString(R.string.no_internet)),
            Pair(NETWORK_ERROR, getErrorString(R.string.network_error)),
            Pair(SEARCH_ERROR, getErrorString(R.string.search_error))
        ).withDefault { getErrorString(R.string.network_error) }
}
