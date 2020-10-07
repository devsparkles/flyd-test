package com.devsparkle.flydapp.presentation.framework.error


interface ErrorFactory {
    fun getError(errorCode: Int): Error
}
