package co.jmoto.roomlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante
import co.jmoto.roomlivedata.ui.EstudianteViewModel
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var estudianteViewModel: EstudianteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLoad = findViewById(R.id.button_load) as Button
        val txtStatus = findViewById(R.id.txtStatus) as TextView

        btnLoad.setOnClickListener {
            var estudiante1 = Estudiante(id = 1,nombres = "Jaime Alberto",primerApellido = "Flautero",segundoApellido = "Valencua",asistencia = 20,ganadoPremio = false)
            var estudiante2 = Estudiante(id = 2,nombres = "Albeiro",primerApellido = "Fernandez",segundoApellido = "Villate",asistencia = 19,ganadoPremio = true)
        }


        estudianteViewModel = ViewModelProvider(this).get(EstudianteViewModel::class.java)

        estudianteViewModel.estudantes.observe(this, Observer { estudiantes ->
            // Update the cached copy of the words in the adapter.
            txtStatus.setText( getNames(estudiantes))
        })




    }

    private fun getNames(estList: List<Estudiante>): String {
        val names = StringBuffer()
        for(est in estList){
            names.append(est.nombres + ' ' + est.primerApellido)
            names.append("\n")
        }
        return names.toString()

    }
}