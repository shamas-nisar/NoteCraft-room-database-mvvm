package com.example.notesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    fun getAllNotesFromDB() : LiveData<List<Note>> = noteDao.getNotes()

    fun insertNoteInDB(note: Note) {
        noteDao.insertNote(note)
    }

    fun deleteNoteFromDB(id: Int) {
        noteDao.deleteNotes(id)
    }

    suspend fun updateNoteInDB(note: Note) {
        noteDao.updateNotesList(note)
    }

}