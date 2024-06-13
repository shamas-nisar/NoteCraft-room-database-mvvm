package com.example.notesapp.ui.fragmentDialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.notesapp.R
import com.example.notesapp.databinding.ShowNoteBinding
import com.example.notesapp.data.model.Note
import com.example.notesapp.ui.MainActivity
import com.example.notesapp.ui.viewmodel.NoteViewModel
import kotlinx.coroutines.launch

class ShowNote(private val note: Note, private val index: Int) : DialogFragment() {

    private var viewBinding: ShowNoteBinding? = null
    private val binding get() = viewBinding!!
    private val viewModel : NoteViewModel by viewModels()


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val mainActivity = activity as MainActivity
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
            viewModel.deleteNotes(index)
            // I will also remove this once i finished other logic,
            // because i think this the logic for shared preferences
            // as the above line of code is for room database
            mainActivity.deleteNote(index)

            Toast.makeText(
                mainActivity,
                resources.getString(R.string.note_deleted),
                Toast.LENGTH_SHORT
            ).show()

            dismiss()
        }

        binding.btnShare.setOnClickListener {
            lifecycleScope.launch {
                // I think i will need to modify this to get the id of the note
                // i am not sure yet
                viewModel.shareNote(id)
                // I will also remove this once i finished other logic,
                // because i think this the logic for shared preferences
                // as the above line of code is for room database
                mainActivity.shareNote(note) // This line calls the shareNote function in MainActivity
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