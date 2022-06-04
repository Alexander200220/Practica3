package com.tecsup.practica3.vistas

import android.app.Application
import androidx.lifecycle.LiveData
import com.tecsup.practica3.database.PracticaRoomDataBase
import com.tecsup.practica3.model.Libro
import com.tecsup.practica3.model.dao.LibroDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LibroRepository (application: Application){
    private val libroDao: LibroDao? = PracticaRoomDataBase.getInstance(application)?.libroDao()

    fun getLibro(): LiveData<List<Libro>> {
        return libroDao?.getListLibro()!!
    }

    //Registro
    suspend fun insertLibroWithCoroutines(libro: Libro){
        processInsertLibro(libro)
    }

    private suspend fun processInsertLibro(libro: Libro){
        withContext(Dispatchers.Default){
            libroDao?.insert(libro)
        }
    }
}