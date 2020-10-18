package com.devsparkle.flydapp.presentation.framework

import androidx.lifecycle.ViewModel
import com.devsparkle.flydapp.BuildConfig
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingSettings
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.strategy.SocketInternetObservingStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

open class FlydViewModel :
    ViewModel() {

    // NetWork call queue via rxjava
    private val disposable: CompositeDisposable =
        CompositeDisposable()

    fun <T> fetch(single: Single<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun isConnected(success: (Boolean) -> Unit, error: (Throwable) -> Unit = {}) {
        val settings = InternetObservingSettings.builder()
            .host(BuildConfig.BASE_URL)
            .strategy(SocketInternetObservingStrategy())
            .build()

        disposable.add(
            ReactiveNetwork.checkInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun <T> fetch(maybe: Maybe<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            maybe
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun <T> fetch(flowable: Flowable<T>, success: (T) -> Unit, error: (Throwable) -> Unit = {}) {
        disposable.add(
            flowable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun complete(
        completable: Completable,
        success: () -> Unit = {},
        error: (Throwable) -> Unit = {}
    ) {
        disposable.add(
            completable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, error)
        )
    }

    fun clear() {
        disposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
