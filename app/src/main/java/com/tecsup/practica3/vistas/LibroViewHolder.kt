package com.tecsup.practica3.vistas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.practica3.R
import com.tecsup.practica3.model.Libro

class LibroViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_libro, parent, false)) {

    private var textTitle: TextView? = null
    private var textAuthor: TextView? = null
    private var textCategory: TextView? = null
    private var textEditorial: TextView? = null
    private var textResume: TextView? = null

    init {
        textTitle = itemView.findViewById(R.id.textTitle)
        textAuthor = itemView.findViewById(R.id.textAuthor)
        textCategory = itemView.findViewById(R.id.textCategory)
        textEditorial = itemView.findViewById(R.id.textEditorial)
        textResume = itemView.findViewById(R.id.textResume)
    }

    fun bind(libro: Libro) {
        textTitle?.text = libro.title
        textAuthor?.text = "Autor: "+ libro.author
        textCategory?.text = "Categoria: "+ libro.category
        textEditorial?.text = "Editorial: "+libro.editorial
        textResume?.text = libro.resume
    }
}