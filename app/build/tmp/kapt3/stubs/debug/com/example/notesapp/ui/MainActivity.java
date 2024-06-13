package com.example.notesapp.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0017H\u0014J\u000e\u0010\'\u001a\b\u0012\u0004\u0012\u00020\t0(H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/example/notesapp/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/notesapp/ui/adapter/NoteAdapter;", "binding", "Lcom/example/notesapp/databinding/ActivityMainBinding;", "myNotes", "Ljava/util/ArrayList;", "Lcom/example/notesapp/data/model/Note;", "getMyNotes", "()Ljava/util/ArrayList;", "setMyNotes", "(Ljava/util/ArrayList;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "viewModel", "Lcom/example/notesapp/ui/viewmodel/NoteViewModel;", "getViewModel", "()Lcom/example/notesapp/ui/viewmodel/NoteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createNewNote", "", "note", "deleteNote", "index", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onStart", "retrieveNotes", "", "saveNotes", "shareNote", "showNote", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.notesapp.ui.adapter.NoteAdapter adapter;
    private com.example.notesapp.databinding.ActivityMainBinding binding;
    private android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.notesapp.data.model.Note> myNotes;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILEPATH = "notes.json";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.notesapp.ui.MainActivity.Companion Companion = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.notesapp.ui.viewmodel.NoteViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.notesapp.data.model.Note> getMyNotes() {
        return null;
    }
    
    public final void setMyNotes(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.notesapp.data.model.Note> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public final void createNewNote(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note) {
    }
    
    public final void deleteNote(int index) {
    }
    
    public final void showNote(int index) {
    }
    
    public final void shareNote(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note) {
    }
    
    private final void saveNotes() {
    }
    
    private final java.util.List<com.example.notesapp.data.model.Note> retrieveNotes() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/notesapp/ui/MainActivity$Companion;", "", "()V", "FILEPATH", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}