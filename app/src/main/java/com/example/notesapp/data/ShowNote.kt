package com.example.notesapp.data

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.notesapp.R
import com.example.notesapp.databinding.ShowNoteBinding
import com.example.notesapp.model.Note
import com.example.notesapp.ui.MainActivity

class ShowNote(private val note: Note, private val index: Int) : DialogFragment() {

    private var _binding: ShowNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val mainActivity = activity as MainActivity
        val inflater = mainActivity.layoutInflater
        _binding = ShowNoteBinding.inflate(inflater)

        val builder = AlertDialog.Builder(mainActivity)
            .setView(binding.root)

        binding.txtTitle.text = note.title
        binding.txtContents.text = note.content

        binding.btnOK.setOnClickListener {
            dismiss()
        }

        binding.btnDelete.setOnClickListener {
            mainActivity.deleteNote(index)

            Toast.makeText(
                mainActivity,
                resources.getString(R.string.note_deleted),
                Toast.LENGTH_SHORT
            ).show()

            dismiss()
        }

        binding.btnShare.setOnClickListener {
            mainActivity.shareNote(note) // This line calls the shareNote function in MainActivity
            Toast.makeText(mainActivity, "Note is being shared..", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}