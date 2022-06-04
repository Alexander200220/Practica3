package com.tecsup.practica3.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tecsup.practica3.model.Libro

@Dao
interface LibroDao {
    @Insert
    fun insert(libro : Libro)

    @Query("SELECT * FROM libro_table ORDER BY title_libro DESC")
    fun getListLibro(): LiveData<List<Libro>>
}