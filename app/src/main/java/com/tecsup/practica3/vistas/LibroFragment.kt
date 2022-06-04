package com.tecsup.practica3.vistas

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tecsup.practica3.R
import com.tecsup.practica3.model.Libro
import kotlinx.android.synthetic.main.dialog_libro.*
import kotlinx.android.synthetic.main.dialog_libro.view.*
import kotlinx.android.synthetic.main.fragment_libro.*

class LibroFragment : Fragment(){
    private lateinit var libroViewModel: LibroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_libro, container,false)
    }
    companion object{
        fun newInstance(): LibroFragment = LibroFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        libroViewModel = run {
            ViewModelProviders.of(this).get(LibroViewModel::class.java)
        }

        fabRegisterLibro.setOnClickListener{
            registerAlertLibro()
        }

        loadData()
    }

    private fun loadData(){
        val adapter = LibroAdapter()
        recyclerLibros.adapter = adapter
        recyclerLibros.layoutManager = LinearLayoutManager(activity)

        libroViewModel.libros.observe(viewLifecycleOwner){libros ->
            if (libros.isNotEmpty()){
                libros?.let{
                    adapter.setLibro(libros)
                }
            }
        }
    }

    private fun registerAlertLibro(){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_libro,null)

        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle("Guardar Libro")
        val mAlertDialog = mBuilder.show()

        mAlertDialog.btnRegisterLibro.setOnClickListener{
            mAlertDialog.dismiss()

            val title = mDialogView.edtTitle.text.toString()
            val author = mDialogView.edtAuthor.text.toString()
            val category = mDialogView.edtCategory.text.toString()
            val editorial = mDialogView.edtEditorial.text.toString()
            val resume = mDialogView.edtResume.text.toString()

            val libro = Libro(title,author,category,editorial,resume)
            libroViewModel.saveLibros(libro)
        }
    }
}