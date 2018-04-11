package ittepic.edu.mx.tap_33_4;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAlumnos extends AppCompatActivity {
    EditText txtnoControl;
    EditText txtnombreAlumno;
    EditText txtfechaNac;
    EditText txtsemestre;
    Button btnregistrar;
    Conexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        //Asignar valor a las variables
        txtnoControl = (EditText) findViewById(R.id.editText8);
        txtnombreAlumno = (EditText) findViewById(R.id.editText9);
        txtfechaNac = (EditText) findViewById(R.id.editText10);
        txtsemestre = (EditText) findViewById(R.id.editText11);
        conexion = new Conexion(this,"SiiDB", null, 1);

        btnregistrar = (Button) findViewById(R.id.button5);
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarAlumno();
            }
        });
    }

    private void registrarAlumno() {
        String noControl = txtnoControl.getText().toString();
        String nombreAlumno = txtnombreAlumno.getText().toString();
        String fechaNac = txtfechaNac.getText().toString();
        String semestre = txtsemestre.getText().toString();

        try{
            SQLiteDatabase db = conexion.getWritableDatabase();
            String SQL = "INSERT INTO ALUMNO VALUES('"+noControl+"','"+nombreAlumno+"','"+fechaNac+"',"+semestre+")";
            db.execSQL(SQL);
            db.close();
            txtnoControl.setText("");
            txtnombreAlumno.setText("");
            txtfechaNac.setText("");
            txtsemestre.setText("");
            Toast.makeText(this, "El alumno se ha registrado correctamente.", Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Toast.makeText(this, "Error al conectar con la base de datos.", Toast.LENGTH_LONG).show();
        }//FIN CATCH

    }


}
