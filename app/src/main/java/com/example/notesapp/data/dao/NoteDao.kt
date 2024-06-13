package com.example.notesapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.data.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNotesList(note: Note)

    @Query("SELECT * FROM notes_table ORDER BY noteID ASC")
    fun getNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes_table WHERE noteId =:id")
    suspend fun shareNote(id: Int): Note?

    @Query("DELETE FROM notes_table WHERE noteId =:id")
    suspend fun deleteNotes(id: Int)

}