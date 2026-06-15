package com.example.notesapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.data.model.Note
import com.example.notesapp.data.repository.NotesRepository
import com.example.notesapp.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow

class NotesViewModel:ViewModel() {
    private val repository=NotesRepository()
    private val _notesState= MutableLiveData<UiState<List<Note>>>()
    val notesState:LiveData<UiState<List<Note>>> = _notesState

    fun loadNotes(){
        _notesState.value=UiState.Loading
        _notesState.value=UiState.Success(repository.getNotes())
    }
    fun addNote(note: Note){
        repository.addNotes(note)
        loadNotes()
    }
    fun deleteNote(note: Note){
        repository.deleteNotes(note)
        loadNotes()
    }
    fun updateNote(note: Note){
        repository.updateNote(note)
        loadNotes()
    }



}