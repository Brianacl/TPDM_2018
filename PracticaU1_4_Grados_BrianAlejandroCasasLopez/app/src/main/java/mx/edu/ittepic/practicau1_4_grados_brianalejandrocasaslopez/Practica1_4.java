package mx.edu.ittepic.practicau1_4_grados_brianalejandrocasaslopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Practica1_4 extends AppCompatActivity {

    EditText editCantidad;
    RadioButton rbtnCentigrados,rbtnFarenheith;
    TextView viewResultado;
    Button btnConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica1_4);

        editCantidad = findViewById(R.id.cantidad);
        rbtnCentigrados = findViewById(R.id.centigrado);
        rbtnFarenheith = findViewById(R.id.farenheith);
        viewResultado = findViewById(R.id.resultado);
        btnConvertir = findViewById(R.id.btnConvertir);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversion();
            }
        });
    }//Fin de onCreate

    protected void conversion(){
        double grados = Double.parseDouble(editCantidad.getText().toString());
        if(rbtnCentigrados.isChecked()){
            grados = grados*(1.8)+32;

            viewResultado.setText(grados +" F°");
        }

        if(rbtnFarenheith.isChecked()){
            grados =(grados-32)/1.8;
            viewResultado.setText(grados +" C°");
        }
        if(editCantidad.getText().toString().length() < 1){
            Toast.makeText(this, grados+"", Toast.LENGTH_SHORT);
        }

        Toast.makeText(this, grados+"", Toast.LENGTH_SHORT).show();
    }//Fin de conversion
}//Fin de clase
