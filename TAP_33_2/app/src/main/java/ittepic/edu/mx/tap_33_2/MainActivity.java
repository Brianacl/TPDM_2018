package ittepic.edu.mx.tap_33_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText n1;
    EditText n2;
    Button suma;
    Button resta;
    Button multiplicacion;
    Button division;


    double resultado;
    double num1;
    double num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazar componente con XML
        n1=(EditText) findViewById(R.id.editText);
        n2=(EditText) findViewById(R.id.editText2);

        suma=(Button) findViewById(R.id.button);
        resta=(Button) findViewById(R.id.button2);
        multiplicacion=(Button) findViewById(R.id.button3);
        division=(Button) findViewById(R.id.button4);
        //AGREGAR LOS ESCUCHADORES
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaSuma();
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaResta();
            }
        });

        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaMultipliacion();
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaDivision();
            }
        });
    }//FIN CONSTRUCTOR

    private void realizaSuma() {
        num1 = Double.parseDouble(n1.getText().toString());
        num2 = Double.parseDouble(n2.getText().toString());

        resultado = num1 + num2;
        Toast.makeText(this,"El resultado de la suma es: "+resultado,Toast.LENGTH_LONG).show();
    }

    private void realizaResta() {
        num1 = Double.parseDouble(n1.getText().toString());
        num2 = Double.parseDouble(n2.getText().toString());

        resultado = num1 - num2;
        Toast.makeText(this,"El resultado de la resta es: "+resultado,Toast.LENGTH_LONG).show();
    }

    private void realizaMultipliacion() {
        num1 = Double.parseDouble(n1.getText().toString());
        num2 = Double.parseDouble(n2.getText().toString());

        resultado = num1 * num2;
        Toast.makeText(this,"El resultado de la multiplicacion es: "+resultado,Toast.LENGTH_LONG).show();
    }

    private void realizaDivision() {
        num1 = Double.parseDouble(n1.getText().toString());
        num2 = Double.parseDouble(n2.getText().toString());

        resultado = num1 / num2;
        Toast.makeText(this,"El resultado de la division es: "+resultado,Toast.LENGTH_LONG).show();
    }
}
