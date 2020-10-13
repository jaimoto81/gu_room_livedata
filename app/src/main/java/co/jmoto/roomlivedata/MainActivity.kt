package co.jmoto.roomlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import co.jmoto.roomlivedata.database.AppDatabase
import co.jmoto.roomlivedata.database.dao.EstudianteDao
import co.jmoto.roomlivedata.database.model.Estudiante

class MainActivity : AppCompatActivity() {

    var baseDatos : AppDatabase ?= null
    var estudianteDao : EstudianteDao ?= null
    lateinit var txtDatos : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        baseDatos = AppDatabase.getAppDatabase(this)
        estudianteDao = baseDatos?.estudianteDao()

        val btnCargar = findViewById<Button>(R.id.btnGuardar)
        txtDatos = findViewById<TextView>(R.id.txtDatos)


        btnCargar.setOnClickListener{
            estudianteDao?.deleteAll()
            estudianteDao?.insert(Estudiante(1L,"Jaime Albeiro","Flautero","Valencia",20,false))
           // estudianteDao?.insert(Estudiante(2L,"Alicia","Vanegas","Castro",22,true))

            val estudiantes = estudianteDao?.getEstudiantes()

            if(estudiantes != null)
                for(estudiante in estudiantes)
                    agregarTexto(estudiante.nombres + " " + estudiante.primerApellido )
        }
    }

    fun agregarTexto(texto: String){
        txtDatos.text = texto
    }
}