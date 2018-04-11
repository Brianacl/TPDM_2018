package mx.edu.ittepic.tpdmu2_ejercicio1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by titab on 22/02/2018.
 */

public class BaseDatos extends SQLiteOpenHelper{
    //Clase abstracta: Metodos obligatorios, también tiene un funcionamiento

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version); //Tiene parametros que se los pasa a la superClase SQLiteOpenHelper
        //Cual es la estructura basica de una abstracta: constructor que pasa parametros a super clase, metodo onCreate, metodo onUpgrade
    }//Fin de contructor

    @Override
    public void onCreate(SQLiteDatabase db) { //Se ejecuta cuando se inicia por primera vez
        /*construye LA ESTRUCTURA de la base de datos en el celular, es decir LAS TABLAS */
        db.execSQL("CREATE TABLE USUARIO(ID INTEGER PRIMARY KEY AUTOINCREMENT, CELULAR VARCHAR(20), CONTRASENA VARCHAR(50))");
    }//Fin de onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Upgrade: Se utiliza para hacer una actualicación A LA ESTRUCTURA de la BD.
    }
}//Fin de clase
