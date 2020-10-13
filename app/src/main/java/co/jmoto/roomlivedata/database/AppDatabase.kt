package co.jmoto.roomlivedata.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante

@Database(entities = [Estudiante::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun estudianteDao(): EstudianteDao

    fun getAppDataBase(context: Context): AppDatabase? {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "myDB")
            .build()
    }

}

