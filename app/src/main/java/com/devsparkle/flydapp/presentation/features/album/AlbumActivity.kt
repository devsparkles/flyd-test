package com.devsparkle.flydapp.presentation.features.album

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsparkle.flydapp.FlydApplication
import com.devsparkle.flydapp.R
import com.devsparkle.flydapp.data.Resource
import com.devsparkle.flydapp.databinding.ActivityAlbumBinding
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.presentation.features.album.adapter.AlbumsAdapter
import com.devsparkle.flydapp.presentation.features.shared.BaseActivity
import com.devsparkle.flydapp.presentation.features.shared.ViewModelFactory
import com.devsparkle.flydapp.utils.observe
import com.devsparkle.flydapp.utils.toGone
import com.devsparkle.flydapp.utils.toVisible
import javax.inject.Inject

class AlbumActivity : BaseActivity() {

    private lateinit var binding: ActivityAlbumBinding

    @Inject
    lateinit var albumViewModel: AlbumViewModel


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var albumsAdapter: AlbumsAdapter

    override fun initViewBinding() {
        binding = ActivityAlbumBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun initializeViewModel() {
         albumViewModel = viewModelFactory.create(AlbumViewModel::class.java)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.title_action_bar_album)
        val layoutManager = LinearLayoutManager(this)
        binding.rvAlbums.layoutManager = layoutManager
        binding.rvAlbums.setHasFixedSize(true)
        albumViewModel.getAlbums()
        albumViewModel.fetchAlbumByName("a")

    }

    private fun showDataView(show: Boolean) {
        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
        binding.rvAlbums.visibility = if (show) View.VISIBLE else View.GONE
        binding.pbLoading.toGone()
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
        binding.rvAlbums.toGone()
    }

    private fun bindListData(albums: List<AlbumDTO>) {
    }

    private fun handleAlbumsList(status: Resource<List<AlbumDTO>>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { bindListData(albums = it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { albumViewModel.showToastMessage(it) }
            }
        }
    }

    override fun observeViewModel() {
        observe(albumViewModel.albumsLiveData, ::handleAlbumsList)
    }
}

