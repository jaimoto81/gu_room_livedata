package co.jmoto.roomlivedata.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Crea la entidad (tabla) en SQLite
@Entity
data class Estudiante(
    @PrimaryKey
    var id: Long = 0L,
    var nombres: String,
    @ColumnInfo(name = "primer_apellido")
    var primerApellido: String,
    @ColumnInfo(name = "segundo_apellido")
    var segundoApellido: String,
    var asistencia: Int,
    @ColumnInfo(name = "premio")
    var ganadoPremio: Boolean
)
