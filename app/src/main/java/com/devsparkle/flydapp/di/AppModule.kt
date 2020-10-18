package com.devsparkle.flydapp.di

import android.app.Application
import androidx.room.Room
import com.devsparkle.flydapp.data.local.FlydDatabase
import com.devsparkle.flydapp.data.mapper.FromDTOtoEntity
import com.devsparkle.flydapp.data.mapper.FromEntityToDTO
import com.devsparkle.flydapp.data.mapper.FromResponseToDTO
import com.devsparkle.flydapp.data.remote.api.DiscogsServiceApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {

    /* @Provides
     @Singleton
     fun provideNetworkDetection(context: Context): NetworkDetection {
         return NetworkDetection(context)
     }
     @Provides
     internal fun provideContext(application: FlydApplication): Context? {
         return application.applicationContext
     }*/

    @Provides
    @Singleton
    fun provideApplicationApiService(retrofit: Retrofit): DiscogsServiceApi {
        return retrofit.create(DiscogsServiceApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
    }

    @Provides
    @Singleton
    internal fun provideFlydDatabase(application: Application): FlydDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            FlydDatabase::class.java, "flyddatabase"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideFromDTOtoEntity(): FromDTOtoEntity {
        return FromDTOtoEntity()
    }

    @Provides
    @Singleton
    internal fun provideFromEntityToDTO(): FromEntityToDTO {
        return FromEntityToDTO()
    }

    @Provides
    @Singleton
    internal fun provideFromResponseToDTO(): FromResponseToDTO {
        return FromResponseToDTO()
    }
}
