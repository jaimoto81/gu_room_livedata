package co.jmoto.roomlivedata.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante


class EstudianteViewModel(application: Application) : AndroidViewModel(application) {

    var baseDatos : AppDatabase?= null
    var estudianteDao : EstudianteDao?= null

    init {
        //iniciacion
        baseDatos = AppDatabase.getAppDatabase(application)
        estudianteDao = baseDatos?.estudianteDao()
    }


    fun insert(estudiante: Estudiante){
        estudianteDao?.insert(estudiante)
    }

    fun listEstudiantes(): List<Estudiante>?{
        return estudianteDao?.getEstudiantes()
    }




}