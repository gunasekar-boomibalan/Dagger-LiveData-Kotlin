package com.android.pbp.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.pbp.sample.Module.Note
import com.android.pbp.sample.Module.NoteDao
import com.android.pbp.sample.di.DaggerApplicationComponent
import com.android.pbp.sample.di.RoomModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var noteDao: NoteDao
    lateinit var recyclerView :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerApplicationComponent.builder().roomModule(RoomModule(application)).build().Inject(this@MainActivity)


        noteDao.all.observe(this, Observer<List<Note>> { note ->
            setlist(note)
        })

    }

    private fun setlist(note: List<Note>) {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = SampleAdapter(note)
    }
}
