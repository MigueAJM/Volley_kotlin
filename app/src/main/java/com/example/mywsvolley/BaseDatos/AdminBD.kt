package com.example.mywsvolley.BaseDatos

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class adminBD(context: Context): SQLiteOpenHelper(context, DATABASE, null,1) {
    companion object{
        val DATABASE = "Inventario"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "Create Table producto(" +
                    "idProd INTEGER primary key," +
                    "nomProd text," +
                    "existencia INTEGER," +
                    "precio float)"
        )
    }
    // Función para mandar ejecutar un INSERT, UPDATE o DELETE
    fun Ejecuta(sentencia: String): Boolean{
        try {
            val db = this.writableDatabase
            db.execSQL(sentencia)
            db.close()
            return true
        }
        catch (ex:Exception){
            return false
        }
    }

    fun Consulta(query: String): Cursor?{
        try {
            val db = this.readableDatabase
            return  db.rawQuery(query,null)
        }
        catch (ex: Exception){
            return null
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}