package com.devsparkle.flydapp.data

import androidx.room.Room
import androidx.room.rxjava3.EmptyResultSetException
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.devsparkle.flydapp.data.local.FlydDatabase
import com.devsparkle.flydapp.data.local.entities.AlbumEntity
import com.devsparkle.flydapp.utils.TestUtil
import org.hamcrest.core.IsEqual
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AlbumDaoTest {

    private lateinit var mDatabase: FlydDatabase

    @Before
    fun createDb() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        mDatabase = Room.inMemoryDatabaseBuilder(appContext, FlydDatabase::class.java)
            .build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun isAlbumListEmpty() {
        Assert.assertEquals(0, mDatabase.albumDao().loadAllAlbums().blockingFirst().size)
    }

    @Test
    @Throws(Exception::class)
    fun insertPhoto() {
        val album: AlbumEntity = TestUtil.createAlbum(7)
        val insertedAlbum = mDatabase.albumDao().insert(album)
        Assert.assertNotNull(insertedAlbum)
    }

    @Test
    @Throws(Exception::class)
    fun insertAlbumAndLoadByTitle() {
        val album: AlbumEntity = TestUtil.createAlbum(1).apply {
            title = "Nirvana"
        }
        mDatabase.albumDao().insert(album)
        val albumLoadedByTitle = mDatabase.albumDao().loadOneAlbumByName("Nirvana")
        Assert.assertThat(albumLoadedByTitle.blockingGet(), IsEqual.equalTo(album))
    }

    @Test
    @Throws(Exception::class)
    fun retrievesPhotos() {
        val photoList = TestUtil.makeAlbumList(5)
        photoList.forEach {
            mDatabase.albumDao().insert(it)
        }

        val loadedPhotos = mDatabase.albumDao().loadAllAlbums()
        Assert.assertEquals(photoList, loadedPhotos.blockingFirst())
    }

    @Test
    @Throws(Exception::class)
    fun deletePhoto() {
        val photo = TestUtil.createAlbum(8)
        mDatabase.albumDao().insert(photo)
        mDatabase.albumDao().delete(photo)

        try {
            mDatabase.albumDao().loadOneAlbumById(8)
        } catch (e: Exception) {
            Assert.assertEquals(e::class, EmptyResultSetException::class)
        }
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllPhotos() {
        mDatabase.albumDao().deleteAll()

        try {
            mDatabase.albumDao().loadAllAlbums()
        } catch (e: Exception) {
            Assert.assertEquals(e::class, EmptyResultSetException::class)
        }
    }
}