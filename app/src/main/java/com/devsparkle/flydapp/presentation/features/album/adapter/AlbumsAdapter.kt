package com.devsparkle.flydapp.presentation.features.album.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devsparkle.flydapp.databinding.AlbumViewBinding
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.presentation.features.album.AlbumViewModel
import com.devsparkle.flydapp.presentation.features.album.listener.RecyclerItemListener

class AlbumsAdapter(private val albumsListViewModel: AlbumViewModel, private val albums: List<AlbumDTO>) : RecyclerView.Adapter<AlbumViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(album: AlbumDTO) {
            albumsListViewModel.openAlbumDetails(album)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemBinding = AlbumViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(albums[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return albums.size
    }
}

