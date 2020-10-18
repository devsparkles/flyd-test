package com.devsparkle.flydapp.presentation.features.artist

import android.os.Bundle
import com.devsparkle.flydapp.R
import com.devsparkle.flydapp.databinding.ActivityArtistBinding
import com.devsparkle.flydapp.presentation.features.shared.BaseActivity
import com.devsparkle.flydapp.presentation.features.shared.ViewModelFactory
import javax.inject.Inject

class ArtistActivity : BaseActivity() {

    private lateinit var binding: ActivityArtistBinding

    @Inject
    lateinit var artistViewModel: ArtistViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun initViewBinding() {
        binding = ActivityArtistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun initViewInteractions() {
        TODO("Not yet implemented")
    }

    override fun initializeViewModel() {
        artistViewModel = viewModelFactory.create(ArtistViewModel::class.java)
    }

    override fun observeViewModel() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.title_action_bar_artist)
    }
}
