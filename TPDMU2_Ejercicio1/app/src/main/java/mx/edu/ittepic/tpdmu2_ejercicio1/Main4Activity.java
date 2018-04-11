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

public class Main4Activity extends AppCompatActivity {

    EditText usuario, contraseña;
    Button btnIngresar;
    BaseDatos dbms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.password);
        btnIngresar = findViewById(R.id.validar);
        dbms = new BaseDatos(this,"LOGIN", null, 1);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view, "¿Desea agregar un usuario?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("AGREGAR", new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Intent otraVista = new Intent(Main4Activity.this, Main2Activity.class);
                                startActivity(otraVista);
                            }
                        }).show();
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validar();
            }
        });

    }

    private void validar(){
        try{
            SQLiteDatabase db = dbms.getReadableDatabase();
            String SQL = "SELECT * FROM USUARIO WHERE CELULAR = {CELULAR} AND CONTRASENA = {PASSWORD}";
            SQL = SQL.replace("{CELULAR}", usuario.getText().toString());
            SQL = SQL.replace("PASSWORD", contraseña.getText().toString());

            Cursor x = db.rawQuery(SQL,null);

            if(x.moveToFirst()){
                Intent exito = new Intent(Main4Activity.this, Main2Activity.class);
                startActivity(exito);
                finish();
            } else{
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("ADVERTENCIA!").setMessage("No se encontró el usuario")
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
            }


        }catch(SQLiteException e){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("ERROR").setMessage(e.getMessage()).show();
        }

    }//Fin validar

}
