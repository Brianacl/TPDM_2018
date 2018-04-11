package ittepic.edu.mx.tap_33_4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by titab on 03/05/2017.
 */

public class Conexion extends SQLiteOpenHelper{
    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //MÉTODO QUE NOS PERMITE CREAR LA BD
        db.execSQL("CREATE TABLE ALUMNO(NOCONTROL VARCHAR(8) NOT NULL PRIMARY KEY, NOMBRE VARCHAR(55), FECHANAC DATE, SEMESTRE INTEGER)");
        db.execSQL("CREATE TABLE MATERIA(IDMATERIA INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NOMBREMATERIA VARCHAR(55),CREDITOS INTEGER)");
        db.execSQL("CREATE TABLE BOLETA(IDBOLETA INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, NOCONTROL CHAR(8), IDMATERIA INTEGER, FALIFICACION INTEGER," +
                   "FOREIGN KEY(NOCONTROL) REFERENCES ALUMNO(NoControl), " +
                   "FOREIGN KEY(IDMATERIA) REFERENCES MATERIA(IDMATERIA))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
