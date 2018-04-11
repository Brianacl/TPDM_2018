package ittepic.edu.mx.tap_33_4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_consulta_materia extends AppCompatActivity {
    EditText txtconsultaMateria;
    Button btnbuscar;
    Conexion conexion;
    EditText txtmostrarMateria;
    EditText txtmostrarCreditos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_materia);

        txtconsultaMateria = (EditText) findViewById(R.id.editText12);
        txtmostrarCreditos = (EditText) findViewById(R.id.editText13);
        txtmostrarMateria = (EditText) findViewById(R.id.editText14);

        btnbuscar = (Button) findViewById(R.id.button6);
        conexion = new Conexion(this,"SiiDB",null,1);

        btnbuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                consultaMateria();
            }
        });
    }

    private void consultaMateria() {
        try{
            SQLiteDatabase db = conexion.getWritableDatabase();
            String materia = txtconsultaMateria.getText().toString();
            String SQL = "SELECT * FROM MATERIA WHERE NOMBREMATERIA='"+materia+"'";
            Cursor res = db.rawQuery(SQL,null);
            if(!res.moveToFirst()){
                Toast.makeText(this,"No se ha encontrado la materia",Toast.LENGTH_LONG).show();
                return;
            }
            txtmostrarMateria.setText(res.getString(1));//Columna nombre materia
            txtmostrarCreditos.setText(res.getString(2));//Columna creditos
            //QUE FALTA?

        }catch(Exception ex){
            Toast.makeText(this, "Error al mostrar la MATERIA.", Toast.LENGTH_LONG).show();
        }
    }
}


