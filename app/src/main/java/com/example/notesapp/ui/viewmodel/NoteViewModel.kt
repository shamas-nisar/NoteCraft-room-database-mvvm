package com.example.notesapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapp.data.database.NoteDatabase
import com.example.notesapp.data.model.Note
import com.example.notesapp.data.repository.NoteRepository

class NoteViewModel(application: Application, private var repository: NoteRepository) : AndroidViewModel(application) {

    init {
        val dao = NoteDatabase.getNoteDatabaseInstance(application).noteDao()
        repository = NoteRepository(dao)
    }

    fun addNotes(note: Note) {
        repository.insertNoteInDB(note)
    }
    fun deleteNotes(id : Int) {
        repository.deleteNoteFromDB(id)
    }

    suspend fun updateNotes(note: Note) {
        repository.updateNoteInDB(note)
    }

    suspend fun shareNote(id: Int) {
        repository.shareNoteFromDB(id)
    }

    fun getNotesAll(): LiveData<List<Note>> = repository.getAllNotesFromDB()

}