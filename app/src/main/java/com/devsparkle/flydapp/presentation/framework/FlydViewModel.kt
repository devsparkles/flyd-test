package com.devsparkle.flydapp.presentation.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.devsparkle.flydapp.FlydApplication

open class FlydViewModel(application: Application) :
    AndroidViewModel(application) {

    protected val application: FlydApplication = getApplication()
}
