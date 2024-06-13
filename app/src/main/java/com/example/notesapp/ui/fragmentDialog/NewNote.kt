package com.example.notesapp.ui.fragmentDialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.notesapp.R
import com.example.notesapp.databinding.NewNoteBinding
import com.example.notesapp.data.model.Note
import com.example.notesapp.ui.MainActivity
import com.example.notesapp.ui.viewmodel.NoteViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewNote : DialogFragment() {

    private var viewBinding: NewNoteBinding? = null
    private val binding get() = viewBinding!!
    private val viewModel : NoteViewModel by viewModels()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val mainActivity = activity as MainActivity
        val inflater = mainActivity.layoutInflater
        viewBinding = NewNoteBinding.inflate(inflater)


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
                val note = Note(
                    noteId = 0,
                    title,
                    contents,
                    true
                )

                viewModel.addNotes(note)
                // i will remove this when i finished other things or other logic,
                // because the above line is used  to add the note to the database
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
        viewBinding = null
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

}