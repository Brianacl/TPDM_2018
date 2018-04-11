package mx.edu.ittepic.tpdmu2_ejercicio1;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

public class Main2Activity extends AppCompatActivity {

    EditText usuario, contrasena;
    Button validar;
    BaseDatos dbms;
    int intentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "¿DESEA REGISTRAR UN USUARIO?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("INSCRIBIR", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent inscribir = new Intent(Main2Activity.this, MainActivity.class);
                                startActivity(inscribir);
                            }
                        }).show();
            }
        });
        usuario = findViewById(R.id.autenticacionusuario);
        contrasena = findViewById(R.id.autenticacioncontrasena);
        validar = findViewById(R.id.validar);
        dbms = new BaseDatos(this, "LOGIN", null,1); //Asignar memoria
        intentos = 0;

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }
        });//Fin de setOnClick de validar
    }//FIN DE onCreate

    private void validar() {
        try{
            //3 partes: 1)Conectar lcon la BD, 2) Ejecutar el SQL, 3) Cerrar la conexión a la BD
            SQLiteDatabase db = dbms.getReadableDatabase();
            Cursor respuesta = db.rawQuery("SELECT * FROM USUARIO WHERE CELULAR = '"
                                           +usuario.getText().toString()+"' AND CONTRASENA = '"
                                           +contrasena.getText().toString()+"'", null);//Objeto puntero
            if(respuesta.moveToFirst()){
                //EXITO
                Intent otraVentana = new Intent(this, Main3Activity.class);
                startActivity(otraVentana);
                finish();
            }else{
                //No es el usuario
                intentos++;
                String error = "ERROR: Usuario y contraseña no válidos\nintento: "+intentos+" de 3";

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("ATENCIÓN").setMessage(error);
                alert.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); //Indica que todo está bien en el positivo
                        if(intentos == 3){finish();}
                        //TAREA: Investigar navigation drawer activity
                    }
                }).show();
            }
            db.close(); //SE CIERRA DESPUÉS DE RECORRER EL CURSOR
        }catch(SQLiteException e){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("ERROR").setMessage(e.getMessage()).show();
        }
    }//fin de validar

}
