package com.example.notesapp.data

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.notesapp.model.Note
import com.example.notesapp.R
import com.example.notesapp.databinding.NewNoteBinding
import com.example.notesapp.ui.MainActivity

class NewNote : DialogFragment() {

    private var _binding: NewNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val mainActivity = activity as MainActivity
        val inflater = mainActivity.layoutInflater
        _binding = NewNoteBinding.inflate(inflater)

        val builder = AlertDialog.Builder(mainActivity)
            .setView(binding.root)
            .setMessage(resources.getString(R.string.add_new_note))

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnOK.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val contents = binding.editContents.text.toString()

            if (title.isNotEmpty() && contents.isNotEmpty()) {
                val note = Note(title, contents)
                mainActivity.createNewNote(note)

                Toast.makeText(mainActivity, resources.getString(R.string.note_saved), Toast.LENGTH_SHORT).show()

                dismiss()
            } else Toast.makeText(mainActivity, resources.getString(R.string.note_empty), Toast.LENGTH_LONG).show()
        }
        return builder.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}