package com.tecsup.practica3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libro_table")
data class Libro(
    @ColumnInfo(name = "title_libro")
    val title: String,

    @ColumnInfo(name = "author_libro")
    val author: String,

    @ColumnInfo(name = "category_libro")
    val category: String,

    @ColumnInfo(name = "editorial_libro")
    val editorial: String,

    @ColumnInfo(name = "resume_libro")
    val resume: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "libro_id")
    var libroID: Int = 0
)
