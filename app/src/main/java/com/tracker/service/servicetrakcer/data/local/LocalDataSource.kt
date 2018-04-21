package com.tracker.service.servicetrakcer.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Enrique on 12/5/2017.
 */
@Database(version = 1,
        entities = []
)
abstract class LocalDataSource : RoomDatabase() {

    companion object {
        fun buildPersistentInstance(context: Context): LocalDataSource = Room.databaseBuilder(
                context.applicationContext,
                LocalDataSource::class.java,
                LocalContract.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

}