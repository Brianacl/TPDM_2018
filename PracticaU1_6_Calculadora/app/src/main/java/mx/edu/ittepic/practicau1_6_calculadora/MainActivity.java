package mx.edu.ittepic.practicau1_6_calculadora;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView viewResultado;
    EditText valor1, valor2;
    Spinner operacion;
    Button calcular;

    float num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewResultado = findViewById(R.id.resultado);
        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        operacion = findViewById(R.id.operacion);
        calcular = findViewById(R.id.btnCalcular);

        String opciones [] = {"Suma","Resta","Multiplicación","División"};
        operacion.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones));

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Float.parseFloat(valor1.getText().toString());
                num2 = Float.parseFloat(valor2.getText().toString());
                String opcion = operacion.getSelectedItem().toString();
                viewResultado.setText(calcular(opcion, num1, num2));
            }
        });
    }//Fin de onCreate

    protected String calcular(String opcion,float num1, float num2) {
        String resultado="";
        if (opcion.equals("Suma")) {
            num1 = num1 + num2;
        }
        if (opcion.equals("Resta")) {
            num1 = num1 - num2;
        }
        if (opcion.equals("Multiplicación")) {
            num1 = num1 * num2;
        }
        if (opcion.equals("División")) {
            num1 = num1 / num2;
        }
        resultado = num1+"";
        return resultado;
    }

}//Fin de clase
