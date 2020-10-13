package co.jmoto.roomlivedata.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante

//Base de datos de la aplicación
//TODO: Estrategias de Migracion entre versiones de la Base de datos
@Database(entities = [Estudiante::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun estudianteDao(): EstudianteDao


    //Usar Singleton - Una sola instancia
    // Implementacion Kotlin - usando companion object
    companion object{
        var INSTANCE: AppDatabase? = null
        //Importante - Inicializar la base de Datos
        fun getAppDatabase(context: Context): AppDatabase? {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "DataBase").allowMainThreadQueries().build()
            }
            return INSTANCE
        }

        fun destroyDateBase(){
            INSTANCE = null
        }

    }




}