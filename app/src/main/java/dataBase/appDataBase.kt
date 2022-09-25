package dataBase

import Beans.Usuarios
import Interface.UsuarioDAO
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Usuarios::class], version = 1)
abstract class appDataBase : RoomDatabase() {
    abstract fun usuariosDAO(): UsuarioDAO?

    companion object {
        var INSTANCE: appDataBase? = null
        fun getInstance(context: Context?): appDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context!!,
                    appDataBase::class.java, "dbUsuarios"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }
    }
}
