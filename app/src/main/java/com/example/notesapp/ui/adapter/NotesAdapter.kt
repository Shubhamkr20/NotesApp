package com.example.notesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.data.model.Note
import com.example.notesapp.databinding.ItemNoteBinding

class NotesAdapter(
    private val notes: MutableList<Note>,
    private val onDelete: (Note) -> Unit
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    // Holds item_note.xml views
    inner class NoteViewHolder(val binding: ItemNoteBinding)
        : RecyclerView.ViewHolder(binding.root)

    // Creates view for one row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NoteViewHolder(binding)
    }

    // Binds data to views
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]

        holder.binding.tvTitle.text = note.title
        holder.binding.tvDescription.text = note.description

        holder.binding.ivDelete.setOnClickListener {
            onDelete(note)
        }
    }

    // Total items count
    override fun getItemCount(): Int = notes.size

    // Update list when data changes
    fun updateNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }
}