package com.example.notesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.model.Note
import com.example.notesapp.ui.MainActivity

class NoteAdapter(private val mainActivity: MainActivity) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var noteList = mutableListOf<Note>()

    inner class NoteViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        internal var title = view.findViewById<View>(R.id.viewTitle) as TextView
        internal var contents = view.findViewById<View>(R.id.viewContents) as TextView

        init {
            view.isClickable = true
            view.setOnClickListener {
                mainActivity.showNote(layoutPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_preview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]

        holder.title.text = note.title
        holder.contents.text = if (note.content.length < 370) note.content
        else note.content.substring(0, 370) + "....."
    }

    override fun getItemCount(): Int = noteList.size
}