package com.example.notesapp.data.repository

import com.example.notesapp.data.model.Note

class NotesRepository {
    private val notesList= mutableListOf<Note>()

    fun getNotes():List<Note>{
        return notesList
    }

    fun addNotes(note: Note){
        notesList.add(note)
    }

    fun deleteNotes(note: Note){
        notesList.remove(note)
    }

    fun updateNote(updatedNote:Note){
        val index=notesList.indexOfFirst { it.id == updatedNote.id }
        if (index!=-1){
            notesList[index]=updatedNote
        }

    }

}