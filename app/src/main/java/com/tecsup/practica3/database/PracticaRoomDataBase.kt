package com.tecsup.practica3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tecsup.practica3.model.Libro
import com.tecsup.practica3.model.dao.LibroDao

@Database(entities = [Libro::class], version = 1)
 abstract class PracticaRoomDataBase: RoomDatabase() {
    abstract fun libroDao(): LibroDao

    companion object{
        private const val DATABASE_NAME = "practica_database"

        @Volatile
        private var INSTANCE: PracticaRoomDataBase? = null

        fun getInstance(context: Context): PracticaRoomDataBase?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PracticaRoomDataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}