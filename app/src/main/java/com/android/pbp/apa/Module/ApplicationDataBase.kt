package com.android.pbp.apa.Module

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Note::class)], version = 1, exportSchema = false)
abstract class ApplicationDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}