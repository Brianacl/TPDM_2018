package ittepic.edu.mx.tap_33_ejercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cajaNombre;
    EditText cajaEdad;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //25 ABRIL - MI PRIMERA VEZ
        cajaNombre = (EditText) findViewById(R.id.editText);
        cajaEdad = (EditText) findViewById(R.id.editText2);

        boton = (Button) findViewById(R.id.button);
        //IMPLEMENTAR EL METODO PARA EL BOTON
        //SE AGREGAN LOS ESCUCHADORES
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = cajaNombre.getText().toString();
                String edad = cajaEdad.getText().toString();

                Toast.makeText(MainActivity.this,"Tu nombre y edad es" + nombre +"-"+ edad,Toast.LENGTH_LONG).show();
            }//FIN DE onClick
        });

    }//Fin constructor
}
