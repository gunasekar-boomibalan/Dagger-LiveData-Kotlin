package com.android.pbp.sample.di

import android.app.Application
import androidx.room.Room
import com.android.pbp.sample.Module.ApplicationDataBase
import com.android.pbp.sample.Module.NoteDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule constructor(application :Application){

    var dataBase : ApplicationDataBase = Room
        .databaseBuilder(application, ApplicationDataBase::class.java, "sample_database")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun providesRoomDatabase() : ApplicationDataBase{
        return dataBase
    }

    @Singleton
    @Provides
    fun providesNoteDao() : NoteDao{
        return dataBase.noteDao()
    }
}