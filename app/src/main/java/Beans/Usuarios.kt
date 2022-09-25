package Beans

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
class Usuarios(
    @field:ColumnInfo(name = "nombre") var nombre: String,
    @field:ColumnInfo(name = "correo") var correo: String,
    @field:ColumnInfo(name = "pass") var pass: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id = 0

}