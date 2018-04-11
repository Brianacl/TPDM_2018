package com.example.titab.tap_33_e1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText edad;
    EditText mensaje;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.editText);
        edad = (EditText) findViewById(R.id.editText2);

        mensaje = (Button) findViewById(R.id.button);

        mensaje.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               String msjnombre = nombre.getText().toString();
               String msjedad = edad.getText().toString();
               Toast.makeText(null,"Hola!", Toast.LENGTH_LONG).show();
           }
        });
    }

}
