package com.example.notesapp.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/notesapp/data/dao/NoteDao;", "", "deleteNotes", "", "id", "", "getNotes", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/notesapp/data/model/Note;", "insertNote", "note", "shareNote", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotesList", "(Lcom/example/notesapp/data/model/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface NoteDao {
    
    @androidx.room.Insert(onConflict = 5)
    public abstract void insertNote(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNotesList(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM notes_table ORDER BY noteID ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.notesapp.data.model.Note>> getNotes();
    
    @androidx.room.Query(value = "UPDATE notes_table SET isShared = 1 WHERE noteId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object shareNote(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "DELETE FROM notes_table WHERE noteId =:id")
    public abstract void deleteNotes(int id);
}