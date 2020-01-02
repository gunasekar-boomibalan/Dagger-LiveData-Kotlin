package com.android.pbp.apa

import android.app.Application
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.room.Room
import com.android.pbp.apa.Module.Note
import com.android.pbp.apa.Module.NoteDao
import com.android.pbp.apa.di.ApplicationComponent
import com.android.pbp.apa.di.DaggerApplicationComponent
import com.android.pbp.apa.di.RoomModule
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject
import androidx.lifecycle.Observer
import java.util.*
import javax.inject.Singleton

@Singleton
class ApaApplication : Application() {


    @Inject
    lateinit var noteDao: NoteDao
    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().roomModule(RoomModule(this@ApaApplication)).build().Inject(this@ApaApplication)

        doAsync {
            val customers: MutableList<Note> = mutableListOf()
            for (index: Int in 0..20) {
                val client = Note("Sample", "Sample Discription", Calendar.getInstance().time.time, 0.0, 0.0)
                customers.add(index, client)
            }
            noteDao.insertAll(customers)
        }
    }
}