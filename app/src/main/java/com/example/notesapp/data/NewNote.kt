package com.example.notesapp.data

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.notesapp.R
import com.example.notesapp.databinding.NewNoteBinding
import com.example.notesapp.model.Note
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

        binding.editContents.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {

                v.append("\n")
                true

            } else {
                false
            }
        }

        binding.editContents.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    val text = it.toString()
                    val formatedText = capitalizeAfterFullStop(text)

                    if (text != formatedText) {
                        binding.editContents.setText(formatedText)
                        binding.editContents.setSelection(formatedText.length)
                    }
                }
            }
        })

        binding.editTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    val text = it.toString()
                    val formatedText = capitalizeAfterFullStop(text)

                    if (text != formatedText) {
                        binding.editTitle.setText(formatedText)
                        binding.editTitle.setSelection(formatedText.length)
                    }
                }
            }
        })


        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnOK.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val contents = binding.editContents.text.toString()

            if (title.isNotEmpty() && contents.isNotEmpty()) {
                val note = Note(title, contents)
                mainActivity.createNewNote(note)

                Toast.makeText(
                    mainActivity,
                    resources.getString(R.string.note_saved),
                    Toast.LENGTH_SHORT
                ).show()

                dismiss()
            } else Toast.makeText(
                mainActivity,
                resources.getString(R.string.note_empty),
                Toast.LENGTH_LONG
            ).show()
        }
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun capitalizeAfterFullStop(text: String): String {
        return text.split(". ").joinToString(". ") { sentence ->
            if (sentence.isNotEmpty()) {
                sentence[0].uppercaseChar() + sentence.substring(1)
            } else {
                sentence
            }
        }
    }

    /*private fun capitalizeAfterPressingEnter(editText: EditText) {
        val text = editText.text.toString()
        val lines = text.split("\n")
        val lastLine = lines.lastOrNull() ?: return

        val capitalizedLastLine = capitalizeAfterFullStop(lastLine)
        val newText = StringBuilder(text)

        // Replace the last line with the capitalized version
        val startIndexOfLastLine = text.lastIndexOf(lastLine)
        newText.replace(startIndexOfLastLine, startIndexOfLastLine + lastLine.length, capitalizedLastLine)

        editText.setText(newText)
        editText.setSelection(newText.length) // Move cursor to end of text
    }*/

}