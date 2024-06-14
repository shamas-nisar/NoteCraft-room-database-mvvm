package com.example.notesapp.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.database.NoteDatabase
import com.example.notesapp.data.model.Note
import com.example.notesapp.data.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(context: Context) : ViewModel() {
    private var repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getNoteDatabaseInstance(context).noteDao()
        repository = NoteRepository(noteDao)
    }

    fun getNotesAll(): LiveData<List<Note>> {
        return repository.getAllNotesFromDB()
    }

    fun addNotes(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNoteInDB(note)
        }
    }

    fun deleteNotes(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNoteFromDB(id)
        }
    }

    suspend fun shareNote(id: Int) {
        repository.shareNoteFromDB(id)
    }

    fun updateNotes(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNoteInDB(note)
        }
    }

    class NoteViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
                return NoteViewModel(context) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}
