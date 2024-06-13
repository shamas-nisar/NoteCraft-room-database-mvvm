package com.example.notesapp.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.R
import com.example.notesapp.ui.adapter.NoteAdapter
import com.example.notesapp.ui.fragmentDialog.NewNote
import com.example.notesapp.ui.fragmentDialog.ShowNote
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.data.model.Note
import com.example.notesapp.ui.viewmodel.NoteViewModel
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
    private val viewModel : NoteViewModel by viewModels {
        NoteViewModel.NoteViewModelFactory(applicationContext)
    }


    companion object {
        private const val FILEPATH = "notes.json"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NoteAdapter(::showNote, ::shareNote, ::deleteNote)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = DefaultItemAnimator()

//        setSupportActionBar(binding.toolbar)
        binding.btnMenu.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.fab.setOnClickListener { view ->
            NewNote().show(supportFragmentManager, null)
        }

//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.itemAnimator = DefaultItemAnimator()

        // Launching the retrieveNotes function whenever the app is launched
        // to display the saved notes
//        adapter.noteList = retrieveNotes()

        // notifyItemRangeInserted will tell the recyclerview that one or more items have been added to the RecyclerView
//        adapter.notifyItemRangeInserted(0, adapter.noteList.size)

        // Initialized the shared preferences variable that is defined at top as a lateinit variable
        // to save and access the shared preferences file
        // I may also comment this if needed later
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        viewModel.getNotesAll().observe(this, Observer { notes ->
            adapter.noteList = notes.toMutableList()
            adapter.notifyDataSetChanged()
        })

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
        viewModel.addNotes(note)
    }

    private fun deleteNote(index: Int) {
        viewModel.deleteNotes(adapter.noteList[index].noteId)
    }

    private fun showNote(index: Int) {
        val dialog = ShowNote(adapter.noteList[index], adapter.noteList[index].noteId)
        dialog.show(supportFragmentManager, null)
    }

    private fun shareNote(note: Note) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "${note.title}\n" +
                    "\n" +
                    "${note.content}")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(intent, "Share Note via: "))


        /*intent.action = Intent.ACTION_SEND
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "${note.title}\n\n${note.content}"
        ) // Assuming 'content' is a property of the Note class
        intent.type = "text/plain" // Set the type to text/plain for sharing text
        val shareThisNote = Intent.createChooser(intent, "Share Note via: ")
        startActivity(shareThisNote)*/
    }

    // This is commented because we are using room database and this is based on json file
    /*private fun saveNotes() {
        val notes = adapter.noteList
        val gson = GsonBuilder().create()
        val jsonNotes = gson.toJson(notes)

        val outputStream = openFileOutput(FILEPATH, Context.MODE_PRIVATE)
        OutputStreamWriter(outputStream).use { writer ->
            writer.write(jsonNotes)
        }
    }*/

    // Also commented because we are using room database and this is based on json file
    /*private fun retrieveNotes(): MutableList<Note> {
        val noteList = mutableListOf<Note>()
        if (getFileStreamPath(FILEPATH).isFile) {
            val fileInput = openFileInput(FILEPATH)
            BufferedReader(InputStreamReader(fileInput)).use { reader ->
                val stringBuilder = StringBuilder()
                reader.forEachLine { line ->
                    stringBuilder.append(line)
                }

                // instead of using reader block of code you can simply use this line of code below
//                (line in reader.readLine()) stringBuilder.append(line)

                if (stringBuilder.isNotEmpty()) {
                    val listType = object : TypeToken<List<Note>>() {}.type
                    noteList.addAll(Gson().fromJson(stringBuilder.toString(), listType))
                }
            }
        }
        return noteList
    }*/

}
