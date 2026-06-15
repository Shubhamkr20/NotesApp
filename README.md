# 📝 NotesApp (Android)

A simple **Notes Application** built using **Kotlin** and **MVVM architecture**.  
This app demonstrates clean architecture, state handling, and modern Android development practices.

---

## 🚀 Features

- ➕ Add notes  
- ✏️ Edit notes  
- 🗑️ Delete notes  
- 📋 Display notes in a list  
- 😕 Show empty state when no notes are available  

---

## 🏗️ Architecture

This project follows **MVVM (Model–View–ViewModel)** architecture.

### Layers:
- **UI (View)** → Activity, Adapter, XML layouts  
- **ViewModel** → Handles UI state and business logic  
- **Repository** → Manages data source  
- **Model** → Data classes  

---

## 📂 Project Structure


com.example.notesapp
│
├── data
│ ├── model
│ │ └── Note.kt
│ └── repository
│ └── NotesRepository.kt
│
├── ui
│ ├── adapter
│ │ └── NotesAdapter.kt
│ ├── view
│ │ └── MainActivity.kt
│ └── viewmodel
│ └── NotesViewModel.kt
│
├── utils
│ └── UiState.kt


---

## 🔄 UI State Handling

The app uses a **sealed class** to manage UI states:

- `Loading`
- `Success`
- `Error`

This ensures:
- Clean UI updates  
- Better error handling  
- Easy scalability  

---

## 🧰 Tech Stack

- **Kotlin**
- **Android ViewModel**
- **LiveData**
- **RecyclerView**
- **ViewBinding**
- **Material Design**
- **Gradle (KTS)**

---

## ▶️ How to Run

1. Clone the repository  
   ```bash
   git clone https://github.com/Shubhamkr20/NotesApp.git
Open in Android Studio
Sync Gradle
Run on emulator or physical device
🧪 Minimum Requirements
Android Studio Flamingo or later
Min SDK: 21
Target SDK: 36
📌 Future Improvements
Room Database
Search notes
Categories
Dark mode
Swipe to delete
