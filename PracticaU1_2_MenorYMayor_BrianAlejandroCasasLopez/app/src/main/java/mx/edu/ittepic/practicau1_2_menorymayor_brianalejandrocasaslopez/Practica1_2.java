package mx.edu.ittepic.practicau1_2_menorymayor_brianalejandrocasaslopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Practica1_2 extends AppCompatActivity {

    TextView resultado;
    EditText primero, segundo, tercero;
    Button btnMenor, btnMayor, btnLimpiar;
    int num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica1_2);

        primero = findViewById(R.id.primerNumero);
        segundo = findViewById(R.id.segundoNumero);
        tercero = findViewById(R.id.tercerNumero);

        resultado = findViewById(R.id.resultado);

        btnMenor = findViewById(R.id.botonMenor);
        btnMayor = findViewById(R.id.botonMayor);
        btnLimpiar = findViewById(R.id.botonLimpiar);


        btnMenor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(primero.getText().toString());
                num2 = Integer.parseInt(segundo.getText().toString());
                num3 = Integer.parseInt(tercero.getText().toString());
                  numeroMenor();
            }
        });

        btnMayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Integer.parseInt(primero.getText().toString());
                num2 = Integer.parseInt(segundo.getText().toString());
                num3 = Integer.parseInt(tercero.getText().toString());
                numeroMayor();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primero.setText("");
                segundo.setText("");
                tercero.setText("");
            }
        });
    }//Fin de onCreate

    protected void numeroMayor(){
        if(num1 > num2 && num1 > num3){resultado.setText("El "+num1+" es el mayor");}
        if(num2 > num1 && num2 > num3){resultado.setText("El "+num2+" es el mayor");}
        if(num3 > num1 && num3 > num2){resultado.setText("El "+num3+" es el mayor");}
    }

    protected void numeroMenor(){
        if(num1 < num2 && num1 < num3){resultado.setText("El "+num1+" es el menor");}
        if(num2 < num1 && num2 < num3){resultado.setText("El "+num2+" es el menor");}
        if(num3 < num1 && num3 < num2){resultado.setText("El "+num3+" es el menor");}
    }

}//Fin clase
