package com.devsparkle.flydapp.presentation.features.album.adapter

import androidx.recyclerview.widget.RecyclerView
import com.devsparkle.flydapp.R
import com.devsparkle.flydapp.databinding.AlbumViewBinding
import com.devsparkle.flydapp.domain.dto.AlbumDTO
import com.devsparkle.flydapp.presentation.features.album.listener.RecyclerItemListener
import com.squareup.picasso.Picasso

class AlbumViewHolder(private val itemBinding: AlbumViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(albumItem: AlbumDTO, recyclerItemListener: RecyclerItemListener) {
        itemBinding.ivAlbumCover.text = albumItem.description
        itemBinding.tvName.text = albumItem.name
        Picasso.get().load(albumItem.thumb).placeholder(R.drawable.ic_healthy_food).error(R.drawable.ic_healthy_food).into(itemBinding.ivAlbumCover)
        itemBinding.rlRecipeItem.setOnClickListener { recyclerItemListener.onItemSelected(albumItem) }
    }
}

