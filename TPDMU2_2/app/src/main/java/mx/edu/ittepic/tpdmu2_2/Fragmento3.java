package mx.edu.ittepic.tpdmu2_2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
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
public class Fragmento3 extends Fragment {

    EditText descripcion, fechacreacion, fechaentrega;
    Button btnActualizar;
    Spinner materia;
    DBTareasTec db;
    EditText idBuscar;//EditText del alertDialog

    public Fragmento3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragmento3, container, false);

        descripcion = v.findViewById(R.id.actdescripcion);
        fechaentrega = v.findViewById(R.id.actfechaentrega);
        fechacreacion = v.findViewById(R.id.actfechacreacion);
        descripcion = v.findViewById(R.id.actdescripcion);
        btnActualizar = v.findViewById(R.id.actboton);
        idBuscar = new EditText(getContext());
        idBuscar.setInputType(InputType.TYPE_CLASS_NUMBER);

        db = new DBTareasTec(getContext(), "TAREASTEC", null,1);
        // Inflate the layout for this fragment

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        alertaPreguntona();
        return v;
    }

    private void alertaPreguntona() {
        AlertDialog.Builder pregunta = new AlertDialog.Builder(getContext());

        pregunta.setTitle("ATENCIÓN!").setMessage("ESCRIBA ID A BUSCAR")
                .setView(idBuscar)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String valorABuscar = idBuscar.getText().toString();

                        if(valorABuscar.isEmpty() == false) {
                            buscarID(valorABuscar);
                        }else{
                            Toast.makeText(getContext(),"ERRO, ID VACIO, NO SE BUSCARÁ", Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(),"SE CANCELÓ BUSQUEDA", Toast.LENGTH_LONG).show();
            }
        }).show();
    }//Fin de alertaPregunta

    private void buscarID(String valorABuscar) {
        try{
            SQLiteDatabase base = db.getReadableDatabase();
            String SQL = "SELECT * FROM TAREA WHERE ID="+valorABuscar;

            Cursor x = base.rawQuery(SQL, null);

            if(!x.moveToFirst()){
                AlertDialog.Builder a = new AlertDialog.Builder(getContext());
                a.setMessage("NO SE ENCONTRO EL ID").show();
                base.close();
                return;
            }

            descripcion.setText(x.getString(1));
            fechacreacion.setText(x.getString(2));
            fechaentrega.setText(x.getString(3));
           // materia. //TODO Tareaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

            descripcion.setEnabled(true);
            fechacreacion.setEnabled(true);
            fechaentrega.setEnabled(true);
            btnActualizar.setEnabled(true);
            materia.setEnabled(true);
        }catch (SQLiteException e){}
    }//fin buscarID

}
