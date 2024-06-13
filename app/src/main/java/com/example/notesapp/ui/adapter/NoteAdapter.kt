package com.example.notesapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.data.model.Note
import kotlin.reflect.KFunction1

class NoteAdapter(
    private val onNoteClicked: (Int) -> Unit,
    private val onNoteActionRequired: (Note) -> Unit,
    private val onDeleteNote: (Int) -> Unit
): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var noteList = mutableListOf<Note>()

    /*@SuppressLint("NotifyDataSetChanged")
    fun filtering(newFilteredList: ArrayList<Note>) {
        notesList = newFilteredList
        notifyDataSetChanged()
    }*/

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal var title = view.findViewById<View>(R.id.viewTitle) as TextView
        internal var contents = view.findViewById<View>(R.id.viewContents) as TextView

        init {
            view.setOnClickListener {
                onNoteClicked.invoke(adapterPosition)
            }
        }

        fun bind(note: Note) {
            title.text = note.title
            contents.text = if (note.content.length < 350) note.content
            else note.content.substring(0, 350) + "....."
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_preview, parent, false)
        return  NoteViewHolder(view)

        /*return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_preview, parent, false)
        )*/
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int = noteList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateNotes(newNotes: List<Note>) {
        noteList.clear()
        noteList.addAll(newNotes)
        notifyDataSetChanged()
    }

}