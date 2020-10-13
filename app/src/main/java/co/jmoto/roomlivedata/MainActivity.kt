package co.jmoto.roomlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante

class MainActivity : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var estudianteDao: EstudianteDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLoad = findViewById(R.id.button_load) as Button
        db = AppDatabase?.getAppDataBase(context = this)
        estudianteDao = db?.estudianteDao()




        btnLoad.setOnClickListener {



            var estudiante1 = Estudiante(id = 1,nombres = "Jaime Alberto",primerApellido = "Flautero",segundoApellido = "Valencua",asistencia = 20,ganadoPremio = false)
            var estudiante2 = Estudiante(id = 2,nombres = "Albeiro",primerApellido = "Fernandez",segundoApellido = "Villate",asistencia = 19,ganadoPremio = true)

            estudianteDao?.insert(estudiante1);
            estudianteDao?.insert(estudiante2);
            println("estudiantes cargados");
            val estudiantes : List<Estudiante> ?= estudianteDao?.getEstudiantes()

            if (estudiantes != null)
                for (estudiante in estudiantes!!){
                    println(estudiante.toString())

                }

        }

    }
}