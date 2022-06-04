package com.tecsup.practica3.vistas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.practica3.model.Libro
import kotlinx.coroutines.launch


class LibroViewModel (application: Application): AndroidViewModel(application) {
    private val repository = LibroRepository(application)

        // Listado
        val libros = repository.getLibro()

        //Resgistro
        fun saveLibros(libro: Libro){
            viewModelScope.launch {
                repository.insertLibroWithCoroutines(libro)
            }
        }

}