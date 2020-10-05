package com.devsparkle.flydapp.presentation.features.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devsparkle.flydapp.FlydApplication
import com.devsparkle.flydapp.R
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    lateinit var searchComponent: SearchComponent

    @Inject
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        searchComponent = (application as FlydApplication).appComponent
            .searchComponent().create()

        searchComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchViewModel.getFirstPage("a") // search "a"
    }
}
