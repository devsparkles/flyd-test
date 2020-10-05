package com.devsparkle.flydapp.presentation.features.album

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devsparkle.flydapp.FlydApplication
import com.devsparkle.flydapp.R
import javax.inject.Inject

class AlbumActivity : AppCompatActivity() {

    lateinit var albumComponent: AlbumComponent

    @Inject
    lateinit var albumViewModel: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        albumComponent = (application as FlydApplication).appComponent
            .albumComponent().create()

        albumComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        albumViewModel.getFirstPage("a") // search "a"
    }
}
