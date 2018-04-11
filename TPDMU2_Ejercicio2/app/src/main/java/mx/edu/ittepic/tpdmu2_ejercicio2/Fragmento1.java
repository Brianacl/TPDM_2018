package mx.edu.ittepic.tpdmu2_ejercicio2;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento1 extends Fragment {

    EditText descripcion, fechaCreacion, fechaEntrega;
    Button btnCrear;
    Spinner materia;
    BaseDatos dbms;

    public Fragmento1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        descripcion = v.findViewById(R.id.actdescripcion);
        fechaEntrega = v.findViewById(R.id.actfechaentrega);
        fechaCreacion = v.findViewById(R.id.actfechacreacion);
        descripcion = v.findViewById(R.id.actdescripcion);
        materia = v.findViewById(R.id.actmateria);
        btnCrear = v.findViewById(R.id.actboton);

        dbms = new BaseDatos(getContext(), "TAREASTEC", null, 1);

        btnCrear.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               crearTarea();
           }
        });
        return v;
    }

    public void crearTarea(){
        try {
            SQLiteDatabase db = dbms.getReadableDatabase();
            String SQL = "INSERT INTO TAREA VALUES(NULL,'{DESCRIPCION}','{FECHACREACION}','{FECHAENTREGA}','{MATERIA}',NULL)";
            SQL = SQL.replace("{DESCRIPCION}", descripcion.getText().toString());
            SQL = SQL.replace("{FECHACREACION}", fechaCreacion.getText().toString());
            SQL = SQL.replace("{FECHAENTREGA}", fechaEntrega.getText().toString());
            SQL = SQL.replace("{MATERIA}", materia.getSelectedItem().toString());

            db.execSQL(SQL);
            db.close();

            descripcion.setText("");
            fechaCreacion.setText("");
            fechaEntrega.setText("");
            Toast.makeText(getContext(), "Se creó nueva tarea", Toast.LENGTH_SHORT).show();

        }catch (SQLiteException e){
            AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
            alerta.setTitle("ATENCIÓN!");
            alerta.setMessage("ERROR: "+ e.getMessage());
            alerta.show();
        }
    }//Fin de crearTarea

}//Fin clase
