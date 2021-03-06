package com.android.pbp.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.pbp.sample.Module.Note

class SampleAdapter(val list: List<Note>) : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {
 
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }
 
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }
 
    override fun getItemCount(): Int {
        return list.size
    }
 
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(note: Note) {
            val textViewName : TextView = itemView.findViewById(R.id.textview)
            textViewName.text = note.title
        }
    }

}