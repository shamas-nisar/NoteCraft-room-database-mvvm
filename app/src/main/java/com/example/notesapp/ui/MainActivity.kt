package com.example.notesapp.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.R
import com.example.notesapp.adapter.NoteAdapter
import com.example.notesapp.data.NewNote
import com.example.notesapp.data.ShowNote
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.model.Note
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NoteAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val FILEPATH = "notes.json"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)
        binding.btnMenu.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.fab.setOnClickListener { view ->
            NewNote().show(supportFragmentManager, null)
        }

        adapter = NoteAdapter(this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = DefaultItemAnimator()

        // Launching the retrieveNotes function whenever the app is launched
        // to display the saved notes
        adapter.noteList = retrieveNotes()
        // notifyItemRangeInserted will tell the recyclerview that one or more items have been added to the RecyclerView
        adapter.notifyItemRangeInserted(0, adapter.noteList.size)

        // Initialized the shared preferences variable that is defined at top as a lateinit variable
        // to save and access the shared preferences file
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

    }

    override fun onStart() {
        super.onStart()

        val nightThemeSelected = sharedPreferences.getBoolean("theme", false)
        if (nightThemeSelected) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val showDividingLines = sharedPreferences.getBoolean("dividingLines", false)
        if (showDividingLines) binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        else if (binding.recyclerView.itemDecorationCount > 0) binding.recyclerView.removeItemDecorationAt(
            0
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    fun createNewNote(note: Note) {
        adapter.noteList.add(note)
        adapter.notifyItemInserted(adapter.noteList.size - 1)
        saveNotes()
    }

    fun deleteNote(index: Int) {
        adapter.noteList.removeAt(index)
        adapter.notifyItemRemoved(index)
        saveNotes()
    }

    fun showNote(index: Int) {
        val dialog = ShowNote(adapter.noteList[index], index)
        dialog.show(supportFragmentManager, null)
    }

    fun shareNote(note: Note) {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "${note.title}\n\n${note.content}"
        ) // Assuming 'content' is a property of the Note class
        intent.type = "text/plain" // Set the type to text/plain for sharing text
        val shareThisNote = Intent.createChooser(intent, "Share Note via: ")
        startActivity(shareThisNote)
    }

    private fun saveNotes() {
        val notes = adapter.noteList
        val gson = GsonBuilder().create()
        val jsonNotes = gson.toJson(notes)

        val outputStream = openFileOutput(FILEPATH, Context.MODE_PRIVATE)
        OutputStreamWriter(outputStream).use { writer ->
            writer.write(jsonNotes)
        }
    }

    private fun retrieveNotes(): MutableList<Note> {
        val noteList = mutableListOf<Note>()
        if (getFileStreamPath(FILEPATH).isFile) {
            val fileInput = openFileInput(FILEPATH)
            BufferedReader(InputStreamReader(fileInput)).use { reader ->
                val stringBuilder = StringBuilder()
                for (line in reader.readLine()) stringBuilder.append(line)

                if (stringBuilder.isNotEmpty()) {
                    val listType = object : TypeToken<List<Note>>() {}.type
                    noteList.addAll(Gson().fromJson(stringBuilder.toString(), listType))
                }
            }
        }
        return noteList
    }

}
