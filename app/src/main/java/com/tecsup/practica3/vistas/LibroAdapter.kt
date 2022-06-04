package com.tecsup.practica3.vistas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.practica3.model.Libro

class LibroAdapter: RecyclerView.Adapter<LibroViewHolder>() {
    private var libroList = emptyList<Libro>()

    fun setLibro(libros: List<Libro>){
        this.libroList = libros
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = libroList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LibroViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro: Libro = libroList[position]
        holder.bind(libro)

    }

}