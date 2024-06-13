package com.example.notesapp.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ \u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u00142\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/example/notesapp/ui/adapter/NoteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/notesapp/ui/adapter/NoteAdapter$NoteViewHolder;", "mainActivity", "Lcom/example/notesapp/ui/MainActivity;", "requireContext", "Landroid/content/Context;", "notesList", "", "Lcom/example/notesapp/data/model/Note;", "(Lcom/example/notesapp/ui/MainActivity;Landroid/content/Context;Ljava/util/List;)V", "noteList", "", "getNoteList", "()Ljava/util/List;", "setNoteList", "(Ljava/util/List;)V", "getRequireContext", "()Landroid/content/Context;", "filtering", "", "newFilteredList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "NoteViewHolder", "app_debug"})
public final class NoteAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.notesapp.ui.adapter.NoteAdapter.NoteViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.example.notesapp.ui.MainActivity mainActivity = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context requireContext = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.notesapp.data.model.Note> notesList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.notesapp.data.model.Note> noteList;
    
    public NoteAdapter(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.ui.MainActivity mainActivity, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.notesapp.data.model.Note> notesList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getRequireContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.notesapp.data.model.Note> getNoteList() {
        return null;
    }
    
    public final void setNoteList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.notesapp.data.model.Note> p0) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void filtering(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.notesapp.data.model.Note> newFilteredList) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.notesapp.ui.adapter.NoteAdapter.NoteViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.notesapp.ui.adapter.NoteAdapter.NoteViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/example/notesapp/ui/adapter/NoteAdapter$NoteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/notesapp/ui/adapter/NoteAdapter;Landroid/view/View;)V", "contents", "Landroid/widget/TextView;", "getContents$app_debug", "()Landroid/widget/TextView;", "setContents$app_debug", "(Landroid/widget/TextView;)V", "title", "getTitle$app_debug", "setTitle$app_debug", "app_debug"})
    public final class NoteViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView title;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView contents;
        
        public NoteViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTitle$app_debug() {
            return null;
        }
        
        public final void setTitle$app_debug(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getContents$app_debug() {
            return null;
        }
        
        public final void setContents$app_debug(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
}