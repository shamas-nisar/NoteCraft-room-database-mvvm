package com.example.notesapp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/notesapp/data/repository/NoteRepository;", "", "noteDao", "Lcom/example/notesapp/data/dao/NoteDao;", "(Lcom/example/notesapp/data/dao/NoteDao;)V", "deleteNoteFromDB", "", "id", "", "getAllNotesFromDB", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/notesapp/data/model/Note;", "insertNoteInDB", "note", "shareNoteFromDB", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNoteInDB", "(Lcom/example/notesapp/data/model/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NoteRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.notesapp.data.dao.NoteDao noteDao = null;
    
    public NoteRepository(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.dao.NoteDao noteDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.notesapp.data.model.Note>> getAllNotesFromDB() {
        return null;
    }
    
    public final void insertNoteInDB(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note) {
    }
    
    public final void deleteNoteFromDB(int id) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object shareNoteFromDB(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateNoteInDB(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}