package com.devsparkle.flydapp.presentation.features.album

import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devsparkle.flydapp.data.Resource
import com.devsparkle.flydapp.di.ActivityScope
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.presentation.framework.FlydViewModel
import javax.inject.Inject

@ActivityScope
class AlbumViewModel @Inject constructor(application: Application) : FlydViewModel(application) {

    /**
     * Data --> LiveData, Exposed as LiveData, Locally in viewModel as MutableLiveData
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val albumsLiveDataPrivate = MutableLiveData<Resource<AlbumDTO>>()
    val albumsLiveData: LiveData<Resource<AlbumDTO>> get() = albumsLiveDataPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<String>()
    val showToast: LiveData<String> get() = showToastPrivate

    fun getAlbumsFirstPage() {
    }

    fun getFirstPage(search: String) {
    }

    fun openAlbumDetails(album: AlbumDTO) {
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = error.description
    }
}
