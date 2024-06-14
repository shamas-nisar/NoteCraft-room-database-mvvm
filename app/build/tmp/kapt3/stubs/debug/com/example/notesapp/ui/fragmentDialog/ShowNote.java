package com.example.notesapp.ui.fragmentDialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/notesapp/ui/fragmentDialog/ShowNote;", "Landroidx/fragment/app/DialogFragment;", "note", "Lcom/example/notesapp/data/model/Note;", "noteId", "", "mainActivity", "Lcom/example/notesapp/ui/MainActivity;", "(Lcom/example/notesapp/data/model/Note;ILcom/example/notesapp/ui/MainActivity;)V", "binding", "Lcom/example/notesapp/databinding/ShowNoteBinding;", "getBinding", "()Lcom/example/notesapp/databinding/ShowNoteBinding;", "viewBinding", "viewModel", "Lcom/example/notesapp/ui/viewmodel/NoteViewModel;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "app_debug"})
public final class ShowNote extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.NotNull()
    private final com.example.notesapp.data.model.Note note = null;
    private final int noteId = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.notesapp.ui.MainActivity mainActivity = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.notesapp.databinding.ShowNoteBinding viewBinding;
    private com.example.notesapp.ui.viewmodel.NoteViewModel viewModel;
    
    public ShowNote(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.data.model.Note note, int noteId, @org.jetbrains.annotations.NotNull()
    com.example.notesapp.ui.MainActivity mainActivity) {
        super();
    }
    
    private final com.example.notesapp.databinding.ShowNoteBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}