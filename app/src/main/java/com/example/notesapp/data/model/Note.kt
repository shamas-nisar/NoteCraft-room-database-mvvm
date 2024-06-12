package com.example.notesapp.data.model

import androidx.room.Entity

@Entity
data class Note(
    val title: String,
    val content: String
)
