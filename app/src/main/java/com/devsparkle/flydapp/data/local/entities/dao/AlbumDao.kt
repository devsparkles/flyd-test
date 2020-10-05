package com.devsparkle.flydapp.data.local.entities.dao

import androidx.room.Dao
import androidx.room.Query
import com.devsparkle.flydapp.data.local.entities.AlbumEntity
import com.devsparkle.flydapp.data.local.shared.BaseDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

/**
 * The Data Access Object for the [AlbumEntity] class.
 */
@Dao
interface AlbumDao : BaseDao<AlbumEntity> {
    @Query("DELETE FROM albums")
    fun delete(): Completable

    @Query("SELECT count(*) FROM albums")
    fun getCount(): Single<Int>

    @Query("SELECT * FROM albums")
    fun getTokens(): Flowable<List<AlbumEntity>>
}
