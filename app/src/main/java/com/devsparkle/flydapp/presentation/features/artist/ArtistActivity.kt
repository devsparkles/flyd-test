package com.devsparkle.flydapp.presentation.features.artist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devsparkle.flydapp.FlydApplication
import com.devsparkle.flydapp.R
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    lateinit var artistComponent: ArtistComponent

    @Inject
    lateinit var artistViewModel: ArtistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        artistComponent = (application as FlydApplication).appComponent
            .artistComponent().create()

        artistComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        artistViewModel.getFirstPage("a") // search "a"
    }
}
