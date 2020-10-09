package com.devsparkle.flydapp.data.error



interface ErrorFactory {
    fun getError(errorCode: Int): Error
}
