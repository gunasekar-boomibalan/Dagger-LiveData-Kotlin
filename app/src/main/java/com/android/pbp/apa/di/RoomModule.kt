package com.android.pbp.apa.di

import android.app.Application
import androidx.room.Room
import com.android.pbp.apa.Module.ApplicationDataBase
import com.android.pbp.apa.Module.NoteDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule constructor(application :Application){

    var dataBase : ApplicationDataBase = Room
        .databaseBuilder(application, ApplicationDataBase::class.java, "apa_database")
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