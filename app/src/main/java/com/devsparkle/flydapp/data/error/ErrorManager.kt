package com.devsparkle.flydapp.data.error

import com.devsparkle.flydapp.data.error.mapper.ErrorMapper
import javax.inject.Inject

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorFactory {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}
