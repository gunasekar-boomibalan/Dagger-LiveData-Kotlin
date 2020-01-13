package com.android.pbp.sample

import android.app.Application
import com.android.pbp.sample.Module.Note
import com.android.pbp.sample.Module.NoteDao
import com.android.pbp.sample.di.DaggerApplicationComponent
import com.android.pbp.sample.di.RoomModule
import org.jetbrains.anko.doAsync
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppClass : Application() {

    @Inject
    lateinit var noteDao: NoteDao
    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().roomModule(RoomModule(this@AppClass)).build().Inject(this@AppClass)

        doAsync {
            val notes: MutableList<Note> = mutableListOf()
            for (index: Int in 0..20) {
                val note = Note("Sample "+index);
                notes.add(index, note)
            }
            noteDao.insertAll(notes)
        }
    }
}