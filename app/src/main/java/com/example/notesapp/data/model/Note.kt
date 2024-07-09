package com.example.notesapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val noteId: Int,
    @ColumnInfo("noteTitle") val title: String,
    @ColumnInfo("noteContent") val content: String,
    val isShared: Boolean
)
