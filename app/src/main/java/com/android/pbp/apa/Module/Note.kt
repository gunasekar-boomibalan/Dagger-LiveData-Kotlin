package com.android.pbp.apa.Module

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note constructor(title : String, description : String, datetime : Long,lat : Double, lang : Double){

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    var title : String? = title
    var description :String? = description
    var datetime : Long? = datetime
    var lat : Double? = lat
    var lang : Double? = lang
}