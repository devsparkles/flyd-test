package com.devsparkle.flydapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.devsparkle.flydapp.data.local.entities.ArtistEntity
import com.devsparkle.flydapp.data.local.shared.BaseDao
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * The Data Access Object for the [ArtistEntity] class.
 */
@Dao
interface ArtistDao : BaseDao<ArtistEntity> {
    @Query("DELETE FROM artists")
    fun deleteAll(): Completable

    @Query("SELECT count(*) FROM artists")
    fun getCount(): Single<Int>

    @Query("SELECT * FROM artists where name=:name")
    fun loadArtistsByName(name: String): Flowable<List<ArtistEntity>>
}
