package co.jmoto.roomlivedata.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante

class EstudianteViewModel(application: Application) : AndroidViewModel(application)
{

    private var db: AppDatabase? = null
    private var dao: EstudianteDao? = null

    init{
        //DELEGAR LA CONSULTA DE LA BD PARA LA PRESENTACION
        db = AppDatabase?.getAppDataBase(application)
        dao = db?.estudianteDao()
    }

    fun insert(estudiante: Estudiante){
        dao?.insert(estudiante);
    }

    fun getAll(): List<Estudiante>? {
        return dao?.getEstudiantes()
    }

}