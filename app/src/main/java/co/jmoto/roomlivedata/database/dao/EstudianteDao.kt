package co.jmoto.roomlivedata.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import co.jmoto.roomlivedata.database.model.Estudiante

//DAO: Referencia al patrón Data Access Object
//Operaciones

@Dao
interface EstudianteDao{

    @Insert
    fun insert(estudiante: Estudiante)

    @Update
    fun update(estudiante: Estudiante)

    //consulta SQL
    @Query("DELETE FROM ESTUDIANTE")
    fun deleteAll()

    @Query("SELECT * FROM ESTUDIANTE")
    fun getEstudiantes(): LiveData<List<Estudiante>>

}