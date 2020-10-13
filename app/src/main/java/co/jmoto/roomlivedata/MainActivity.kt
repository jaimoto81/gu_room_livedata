package co.jmoto.roomlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante
import co.jmoto.roomlivedata.ui.EstudianteViewModel

class MainActivity : AppCompatActivity() {

    lateinit var txtDatos : TextView
    lateinit var estudianteViewModel: EstudianteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicializar el ViewModel
        estudianteViewModel = ViewModelProvider(this).get(EstudianteViewModel::class.java)

        val btnCargar = findViewById<Button>(R.id.btnGuardar)
        txtDatos = findViewById<TextView>(R.id.txtDatos)
        btnCargar.setOnClickListener{
            estudianteViewModel?.insert(Estudiante("Federico","Camacho","",20,false))
            estudianteViewModel?.insert(Estudiante("Alejandro","Ramirez","Name",22,true))
        }

        //OBSERVER -
        estudianteViewModel.estudiantes.observe(this, Observer { lstEstudiantes -> agregarTexto(lstEstudiantes)  })

    }

    fun agregarTexto(estudiantes: List<Estudiante>?){
        var texto = StringBuffer()
        for(estudiante in estudiantes!!){
            texto.append(estudiante.nombres + " " + estudiante.primerApellido)
            texto.append("\n")
        }
        txtDatos.text = texto
    }
}