package mx.edu.ittepic.tpdmu2_ejercicio2;


import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento4 extends Fragment {

    ListView listaTareas;
    BaseDatos dbms;
    AlertDialog.Builder alert;

    public Fragmento4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento4, container, false);
        dbms = new BaseDatos(getContext(), "TAREASTEC", null,1);
        alert = new AlertDialog.Builder(getContext());
        listaTareas = v.findViewById(R.id.delListaTareas);
        hacerSelect();
        return v;
    }//fin de onCreate

    private void hacerSelect(){
        try {
            int i=0;
            SQLiteDatabase db = dbms.getReadableDatabase();

            String SQL = "SELECT * FROM TAREA";
            Cursor x = db.rawQuery(SQL, null);
            if (x.moveToFirst() == false) {
                alert.setTitle("ATENCIÓN!").setMessage("No hay tareas que eliminar").show();
                db.close();
                return;
            }
            String tareas[] = new String[x.getCount()];

            do{
                tareas[i] = x.getString(1);
            }while(x.moveToNext());


            //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, tareas);
            //listaTareas.setAdapter(adaptador);
            db.close();
        }catch (SQLiteException e){
            alert.setTitle("ERROR!").setMessage(e.getMessage()).show();
        }
    }//fin de hacerSelect

}//Fin de clase
