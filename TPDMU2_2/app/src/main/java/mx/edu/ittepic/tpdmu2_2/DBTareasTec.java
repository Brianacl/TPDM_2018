package mx.edu.ittepic.tpdmu2_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by titab on 05/03/2018.
 */

public class DBTareasTec extends SQLiteOpenHelper {

    public DBTareasTec(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TAREA(ID INTEGER PRIMARY KEY AUTOINCREMENT, DESCRIPCION VARCHAR(500), " +
                   "FECHACREACION DATE, FECHAENTREGA DATE, MATERIA VARCHAR(200), ENTREGADO INTEGER)");
    } //onCreate

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    } //onUpgrade
}
