package com.example.notesapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.ui.adapter.NotesAdapter
import com.example.notesapp.ui.viewmodel.NotesViewModel
import com.example.notesapp.utils.UiState

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NotesViewModel by viewModels()
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NotesAdapter(mutableListOf()) {
            viewModel.deleteNote(it)
        }

        binding.recyclerViewNotes.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewNotes.adapter = adapter

       // binding.fabAddNote.setOnClickListener {
         //   startActivity(Intent(this, AddEditNoteActivity::class.java))
       // }

        viewModel.notesState.observe(this) {
            if (it is UiState.Success) {
                adapter.updateNotes(it.data)
                binding.tvEmptyState.visibility =
                    if (it.data.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
            }
        }

        viewModel.loadNotes()
    }
}