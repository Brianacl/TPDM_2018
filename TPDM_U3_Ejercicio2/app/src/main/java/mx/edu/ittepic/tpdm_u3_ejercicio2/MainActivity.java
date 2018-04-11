package mx.edu.ittepic.tpdm_u3_ejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnEjecutar;
    Generador objetoAsincrono;
    EditText txtCantidad, txtMaximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEjecutar = findViewById(R.id.btnEjecutar);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtMaximo = findViewById(R.id.txtMaximo);
        //objetoAsincrono = new Generador(); //Si se deja aquí cuando se presine de nuevo el bóton
                                              //se cerrara la aplicación ya que ya se uso el metodo execute
                                              //por eso es necesario moverlo a adentro del metodo del boton

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cant = Integer.parseInt(txtCantidad.getText().toString());
                int maxi = Integer.parseInt(txtMaximo.getText().toString());

                objetoAsincrono = new Generador(MainActivity.this);
                objetoAsincrono.execute(cant, maxi);
            }
        });
    }
}
