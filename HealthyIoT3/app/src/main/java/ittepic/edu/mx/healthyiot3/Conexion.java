package ittepic.edu.mx.healthyiot3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by titab on 19/05/2017.
 */

public class Conexion extends SQLiteOpenHelper{
    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //MÉTODO QUE NOS PERMITE CREAR LA BD
        db.execSQL("CREATE TABLE USUARIO(IDUSUARIO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NOMBRE VARCHAR(55), EDAD INTEGER, PESO FLOAT, CORREO VARCHAR(70), EN_CRONICAS VARCHAR(200))");
        db.execSQL("CREATE TABLE CONTACTOS(IDCONTACTO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NOMBRECONTACTO VARCHAR(55),TELEFONO VARCHAR(10))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
