package Interface

import Beans.Usuarios
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDAO {
    @Insert
    fun insert(usu: Usuarios?)

    @Query("SELECT * FROM usuarios")
    fun listaUsuarios(): List<Usuarios?>?
}