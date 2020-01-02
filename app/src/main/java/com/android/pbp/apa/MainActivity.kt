package com.android.pbp.apa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import com.android.pbp.apa.Module.ApplicationDataBase
import com.android.pbp.apa.Module.Note
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ApaApplication).noteDao.all.observe(this, Observer<List<Note>>{ note ->
            for (i in 0..note.size-1) {
                Log.i("Test"," "+i)
        }})

    }
}
