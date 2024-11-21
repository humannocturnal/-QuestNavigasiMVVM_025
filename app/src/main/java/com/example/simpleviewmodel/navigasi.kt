package com.example.simpleviewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Halaman {
    Form,
    Data
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            modifier = modifier.padding(innerPadding),
            navController = navHost,
            startDestination = Halaman.Form.name
        ) {
            // Halaman Form
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current

                FormulirView(
                    pilihanJk = DataJK.isiJk.map { isi ->
                        konteks.resources.getString(isi)
                    },
                    onClickButton = { data ->
                        viewModel.saveDataMahasiswa(data)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }

            // Halaman Data (tambahkan komponen UI sesuai kebutuhan)
            composable(route = Halaman.Data.name) {
                Text(text = "Data berhasil disimpan!") // Contoh halaman data
            }
        }
    }
}


private fun ViewModel.saveDataMahasiswa(data: String) {
    TODO("Not yet implemented")
}

fun composable(route: String, function: () -> Unit) {
    TODO("Not yet implemented")
}

object DataJK {
    val isiJk = listOf(
        R.string.laki,
        R.string.wanita
    )
}

@Composable
fun FormulirView(
    pilihanJk: List<String>,
    onClickButton: (String) -> Unit
) {
    Column {
        // Dropdown atau pilihan untuk jenis kelamin
        pilihanJk.forEach { pilihan ->
            Text(text = pilihan)
        }

        // Tombol untuk mengirim data
        Button(onClick = { onClickButton("data contoh") }) {
            Text("Simpan")
        }
    }
}