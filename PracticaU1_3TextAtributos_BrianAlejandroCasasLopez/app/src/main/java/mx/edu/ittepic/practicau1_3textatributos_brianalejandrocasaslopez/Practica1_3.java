package mx.edu.ittepic.practicau1_3textatributos_brianalejandrocasaslopez;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Practica1_3 extends AppCompatActivity {

    Spinner spinnerColores;
    EditText editMensaje;
    Button btnAccion;
    TextView viewMensaje;
    String mensaje, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica1_3);

        spinnerColores = findViewById(R.id.spinnerColores);
        editMensaje = findViewById(R.id.mensaje);
        btnAccion = findViewById(R.id.btnaccion);
        viewMensaje = findViewById(R.id.viewMensaje);

        String colores [] = {"AZUL","ROJO","AMARILLO","VERDE"};
        spinnerColores.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colores));

        btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMensaje.setText(editMensaje.getText().toString());
                color = spinnerColores.getSelectedItem().toString();
                textoColor(color);
            }
        });
    }//Fin de onCreate

    protected void textoColor(String color){
        if(color.equals("AZUL")){viewMensaje.setTextColor(Color.BLUE);}
        if(color.equals("ROJO")){viewMensaje.setTextColor(Color.RED);}
        if(color.equals("AMARILLO")){viewMensaje.setTextColor(Color.YELLOW);}
        if(color.equals("VERDE")){viewMensaje.setTextColor(Color.GREEN);}
        if(viewMensaje.getText().length()< 1){
            viewMensaje.setText("Escriba un mensaje primero, por favor");
            viewMensaje.setTextColor(Color.BLACK);
        }
    }
}//Fin clase
