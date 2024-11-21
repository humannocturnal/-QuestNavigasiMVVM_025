package com.example.simpleviewmodel.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MahasiswaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> get() = _uiState

    // Fungsi untuk menyimpan data mahasiswa
    fun saveDataMahasiswa(data: String) {
        // Logika penyimpanan data
        _uiState.value = UiState(dataDisimpan = true)
    }
}

data class UiState(
    val dataDisimpan: Boolean = false
)