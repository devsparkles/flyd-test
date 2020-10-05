package com.devsparkle.flydapp.data.local.shared

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import java.util.Date

interface BaseDao<T> where T : BaseEntity {
    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)

    /**
     * Insert an array of objects in the database.
     *
     * @param obj the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T)

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    fun update(obj: T)

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    fun delete(obj: T)

    companion object {
        open class DAOWrapper<P, T>(private val daoInstance: T) where T : BaseDao<P>, P : BaseEntity {
            fun insertWithTimestampData(modelData: P) {
                modelData.modificationDate = Date(System.currentTimeMillis())
                this@DAOWrapper.daoInstance.insert(modelData)
            }
        }
    }
}
