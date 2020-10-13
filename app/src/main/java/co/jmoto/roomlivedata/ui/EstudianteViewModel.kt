package co.jmoto.roomlivedata.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante

//ViewModel - Apps  Móviles - Android :: MVVM - Modelo Vista ViewModel
class EstudianteViewModel(application: Application) : AndroidViewModel(application) {

    var baseDatos : AppDatabase?= null
    var estudianteDao : EstudianteDao?= null
    val estudiantes: LiveData<List<Estudiante>>



    init {
        //iniciacion
        baseDatos = AppDatabase.getAppDatabase(application)
        estudianteDao = baseDatos?.estudianteDao()
        estudiantes = estudianteDao!!.getEstudiantesLiveData()
    }


    fun insert(estudiante: Estudiante){
        estudianteDao?.insert(estudiante)
    }


}