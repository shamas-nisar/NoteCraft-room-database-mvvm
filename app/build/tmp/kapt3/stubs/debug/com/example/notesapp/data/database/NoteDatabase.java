package com.example.notesapp.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/notesapp/data/database/NoteDatabase;", "Landroidx/room/RoomDatabase;", "()V", "noteDao", "Lcom/example/notesapp/data/dao/NoteDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.notesapp.data.model.Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.notesapp.data.database.NoteDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.notesapp.data.database.NoteDatabase.Companion Companion = null;
    
    public NoteDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.notesapp.data.dao.NoteDao noteDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/example/notesapp/data/database/NoteDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/notesapp/data/database/NoteDatabase;", "getINSTANCE", "()Lcom/example/notesapp/data/database/NoteDatabase;", "setINSTANCE", "(Lcom/example/notesapp/data/database/NoteDatabase;)V", "getNoteDatabaseInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.notesapp.data.database.NoteDatabase getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable()
        com.example.notesapp.data.database.NoteDatabase p0) {
        }
        
        @kotlin.OptIn(markerClass = {kotlinx.coroutines.InternalCoroutinesApi.class})
        @org.jetbrains.annotations.NotNull()
        public final com.example.notesapp.data.database.NoteDatabase getNoteDatabaseInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}