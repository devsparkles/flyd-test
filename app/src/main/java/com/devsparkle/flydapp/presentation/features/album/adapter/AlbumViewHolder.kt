package com.devsparkle.flydapp.presentation.features.album.adapter

import androidx.recyclerview.widget.RecyclerView
import com.devsparkle.flydapp.R
import com.devsparkle.flydapp.databinding.AlbumViewBinding
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.presentation.features.album.listener.RecyclerItemListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_view.view.tv_album_artist

class AlbumViewHolder(private val itemBinding: AlbumViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(albumItem: AlbumDTO, recyclerItemListener: RecyclerItemListener) {
        itemBinding.tvAlbumArtist.text = albumItem.artist
        itemBinding.tvAlbumTitle.text = albumItem.title
        Picasso.get().load(albumItem.coverImageUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_error_placholder).into(itemBinding.ivAlbumCover)
        itemBinding.albumLine.setOnClickListener { recyclerItemListener.onItemSelected(albumItem) }
    }
}

