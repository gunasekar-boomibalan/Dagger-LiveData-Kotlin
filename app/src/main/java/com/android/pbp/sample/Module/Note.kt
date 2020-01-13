package com.android.pbp.sample.Module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note constructor(title : String){

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    var title : String? = title
}