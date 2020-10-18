package com.devsparkle.flydapp.utils

import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun View.toVisible() {
    this.visibility = View.VISIBLE
}

fun View.toGone() {
    this.visibility = View.GONE
}

fun SwipeRefreshLayout.toGone() {
    this.isRefreshing = false
}

fun SwipeRefreshLayout.toVisible() {
    this.isRefreshing = true
}

fun View.toInvisible() {
    this.visibility = View.GONE
}

