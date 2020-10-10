package com.devsparkle.flydapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devsparkle.flydapp.data.local.entities.AlbumEntity
import com.devsparkle.flydapp.data.local.shared.BaseDao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

/**
 * The Data Access Object for the [AlbumEntity] class.
 */
@Dao
interface AlbumDao : BaseDao<AlbumEntity> {


    @Query("DELETE FROM albums")
    fun delete(): Completable

    @Query("SELECT * FROM albums")
    fun getAlbums(): Flowable<List<AlbumEntity>>

    @Query("SELECT * FROM albums where title=:name")
    fun getAlbumsByName(name: String): Flowable<List<AlbumEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<AlbumEntity>)
}
