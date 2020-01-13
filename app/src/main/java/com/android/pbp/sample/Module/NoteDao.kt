package com.android.pbp.sample.Module

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NoteDao {
    @get:Query("SELECT * FROM Note")
    public val all: LiveData<List<Note>>

    @Insert
    fun insertAll(notes: List<Note>)

    @Insert
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)
}