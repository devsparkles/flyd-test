package com.devsparkle.flydapp.presentation.features.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devsparkle.flydapp.FlydApplication
import com.devsparkle.flydapp.R
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}
