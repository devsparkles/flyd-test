package com.devsparkle.flydapp.presentation.features.album

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devsparkle.flydapp.data.Resource
import com.devsparkle.flydapp.data.error.DEFAULT_ERROR
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.domain.usecases.album.GetAlbumsUseCase
import com.devsparkle.flydapp.presentation.framework.FlydViewModel
import javax.inject.Inject

class AlbumViewModel @Inject constructor(private val getAlbumsUseCase: GetAlbumsUseCase) :
    FlydViewModel() {

    /**
     * Data --> LiveData, Exposed as LiveData, Locally in viewModel as MutableLiveData
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val albumsLiveDataPrivate = MutableLiveData<Resource<List<AlbumDTO>>>()
    val albumsLiveData: LiveData<Resource<List<AlbumDTO>>> get() = albumsLiveDataPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<String>()
    val showToast: LiveData<String> get() = showToastPrivate

    fun fetchAlbumByName(name: String) {
        fetch(getAlbumsUseCase.getAlbumListByNameRemote(name),
            { albums ->
                complete(getAlbumsUseCase.saveAlbum(albums))
            },
            {
                albumsLiveDataPrivate.value = Resource.DataError(DEFAULT_ERROR)
            })
    }


    fun getAlbums() {
        albumsLiveDataPrivate.value = Resource.Loading()
        fetch(getAlbumsUseCase.getAlbumList(),
            {
                albumsLiveDataPrivate.value = Resource.Success(it)
            },
            {
                albumsLiveDataPrivate.value = Resource.DataError(DEFAULT_ERROR)
            })
    }



    fun getAlbumsFirstPage(name: String) {
        albumsLiveDataPrivate.value = Resource.Loading()
        fetch(getAlbumsUseCase.getAlbumListByName(name),
            {
                albumsLiveDataPrivate.value = Resource.Success(it)
            },
            {
                albumsLiveDataPrivate.value = Resource.DataError(DEFAULT_ERROR)
            })
    }

    fun openAlbumDetails(album: AlbumDTO) {
    }

    fun showToastMessage(errorCode: Int) {
        //val error = errorManager.getError(errorCode)
       // showToastPrivate.value = error.description
    }
}
