package mx.edu.ittepic.tpdmu2_ejercicio2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Fragmento2 extends Fragment {

    ListView listaTareas;
    BaseDatos dbms;

    public Fragmento2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento1, container, false);
        dbms = new BaseDatos(getContext(), "TAREASTEC", null,1);
        listaTareas = v.findViewById(R.id.listaTareas);
        hacerSelect();
        return v;
    }//Fin onCreateView

    private void hacerSelect(){
        try {
            SQLiteDatabase db = dbms.getReadableDatabase();

            String SQL = "SELECT * FROM TAREA";

            Cursor x = db.rawQuery(SQL, null);
            if(!x.moveToFirst()){
                AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                alerta.setTitle("ATENCIÓN!")
                        .setMessage("TAREAS VACIAS");
                alerta.show();
                db.close();
                return;
            }

            String []tareas = new String[x.getCount()];
            for(int i=0; i < x.getCount(); i++){
                tareas[i] = x.getString(1);
            }
            db.close();

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.activity_list_item, tareas);
            listaTareas.setAdapter(adaptador);
            Toast.makeText(getContext(),tareas[1],Toast.LENGTH_LONG).show();
        }catch(SQLiteException e){
            AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
            alerta.setTitle("ATENCIÓN!").setMessage("ERROR: "+ e.getMessage()).show();
        }
    }//fin hacerSelect
}//Fin clase
