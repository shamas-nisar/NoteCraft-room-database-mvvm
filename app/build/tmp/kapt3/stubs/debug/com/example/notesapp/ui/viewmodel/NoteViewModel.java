package com.example.notesapp.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\u000fJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/notesapp/ui/viewmodel/NoteViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "repository", "Lcom/example/notesapp/data/repository/NoteRepository;", "(Landroid/app/Application;Lcom/example/notesapp/data/repository/NoteRepository;)V", "addNotes", "", "note", "Lcom/example/notesapp/data/model/Note;", "deleteNotes", "id", "", "getNotesAll", "Landroidx/lifecycle/LiveData;", "", "shareNote", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotes", "(Lcom/example/notesapp/data/model/Note;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NoteViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private com.example.notesapp.data.repository.NoteRepository repository;
    
    public NoteViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.repository.NoteRepository repository) {
        super(null);
    }
    
    public final void addNotes(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note) {
    }
    
    public final void deleteNotes(int id) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateNotes(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object shareNote(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.notesapp.data.model.Note>> getNotesAll() {
        return null;
    }
}