package com.devsparkle.flydapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devsparkle.flydapp.data.local.entities.AlbumEntity
import com.devsparkle.flydapp.data.local.shared.BaseDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * The Data Access Object for the [AlbumEntity] class.
 */
@Dao
interface AlbumDao : BaseDao<AlbumEntity> {

    @Query("SELECT * FROM albums where id=:id")
    fun loadOneAlbumById(id: Long): Single<AlbumEntity>

    @Query("DELETE FROM albums")
    fun deleteAll()

    @Query("SELECT * FROM albums")
    fun loadAllAlbums(): Flowable<List<AlbumEntity>>

    @Query("SELECT * FROM albums where title LIKE :name")
    fun loadAlbumsByName(name: String): Flowable<List<AlbumEntity>>

    @Query("SELECT * FROM albums where title=:name LIMIT 1")
    fun loadOneAlbumByName(name: String): Single<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<AlbumEntity>): Completable
}
