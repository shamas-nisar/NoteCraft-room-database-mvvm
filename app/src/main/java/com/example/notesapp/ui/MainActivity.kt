package com.example.notesapp.ui

import android.annotation.SuppressLint
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
import com.example.notesapp.data.model.Note
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.ui.adapter.NoteAdapter
import com.example.notesapp.ui.fragmentDialog.NewNote
import com.example.notesapp.ui.fragmentDialog.ShowNote
import com.example.notesapp.ui.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NoteAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val viewModel : NoteViewModel by viewModels {
        NoteViewModel.NoteViewModelFactory(applicationContext)
    }


   /* companion object {
        private const val FILEPATH = "notes.json"
    }*/

    @SuppressLint("NotifyDataSetChanged")
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
        val dialog = ShowNote(adapter.noteList[index], adapter.noteList[index].noteId, this)
        dialog.show(supportFragmentManager, null)
    }

    private fun shareNote(note: Note) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "${note.title}\n\n${note.content}")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(intent, "Share Note via: "))
    }

}

