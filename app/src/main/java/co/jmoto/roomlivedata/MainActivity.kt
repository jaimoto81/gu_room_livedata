package co.jmoto.roomlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante
import co.jmoto.roomlivedata.ui.EstudianteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var estudianteViewModel: EstudianteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLoad = findViewById(R.id.button_load) as Button
        btnLoad.setOnClickListener {
            var estudiante1 = Estudiante(id = 1,nombres = "Jaime Alberto",primerApellido = "Flautero",segundoApellido = "Valencua",asistencia = 20,ganadoPremio = false)
            var estudiante2 = Estudiante(id = 2,nombres = "Albeiro",primerApellido = "Fernandez",segundoApellido = "Villate",asistencia = 19,ganadoPremio = true)
        }


        estudianteViewModel = ViewModelProvider(this).get(EstudianteViewModel::class.java)




    }
}