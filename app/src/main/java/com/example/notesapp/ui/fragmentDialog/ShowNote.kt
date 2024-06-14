package com.example.notesapp.ui.fragmentDialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.util.newStringBuilder
import com.example.notesapp.R
import com.example.notesapp.data.model.Note
import com.example.notesapp.databinding.ShowNoteBinding
import com.example.notesapp.ui.MainActivity
import com.example.notesapp.ui.viewmodel.NoteViewModel
import kotlinx.coroutines.launch

class ShowNote(private val note: Note, private val noteId: Int, private val mainActivity: MainActivity) : DialogFragment() {

    private var viewBinding: ShowNoteBinding? = null
    private val binding get() = viewBinding!!
    private lateinit var viewModel: NoteViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val mainActivity = activity as MainActivity

        val viewModelFactory = NoteViewModel.NoteViewModelFactory(mainActivity.applicationContext)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel::class.java)

        val inflater = mainActivity.layoutInflater
        viewBinding = ShowNoteBinding.inflate(inflater)

        val builder = AlertDialog.Builder(mainActivity)
            .setView(binding.root)

        binding.txtTitle.text = note.title
        binding.txtContents.text = note.content

        binding.btnOK.setOnClickListener {
            dismiss()
        }

        binding.btnDelete.setOnClickListener {
            AlertDialog.Builder(mainActivity)
                .setTitle("Delete Note")
                .setMessage("Are you sure you want to delete this note?")
                .setPositiveButton("Delete") { _, _ ->
                    lifecycleScope.launch {
                        try {
                            viewModel.deleteNotes(noteId)
                            Toast.makeText(
                                mainActivity,
                                resources.getString(R.string.note_deleted),
                                Toast.LENGTH_SHORT
                            ).show()
                            dismiss()

                        } catch (e: Exception) {
                            Toast.makeText(
                                mainActivity,
                                "Failed to delete note: ${e.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }.setNegativeButton("Cancel", null)
                .show()
        }

        binding.btnShare.setOnClickListener {
            lifecycleScope.launch {
                try {
                    viewModel.shareNote(note.noteId)
                    Toast.makeText(
                        mainActivity,
                        "Note is being shared..",
                        Toast.LENGTH_SHORT
                    ).show()
                    dismiss()

                } catch (e: Exception) {
                    Toast.makeText(
                        mainActivity,
                        "Failed to share note: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                // I think i will need to modify this to get the id of the note
                // i am not sure yet--------------------------->
//                viewModel.shareNote(note.noteId)

                // I will also remove this once i finished other logic,
                // because i think this the logic for shared preferences
                // as the above line of code is for room database
//                mainActivity.shareNote(note) // This line calls the shareNote function in MainActivity

                Toast.makeText(mainActivity, "Note is being shared..", Toast.LENGTH_SHORT).show()
                dismiss()
            }
        }

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}