package mx.edu.ittepic.practicau1_8_mayorymenor_brianalejandrocasaslopez;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText primero, segundo, tercero;
    int num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primero = findViewById(R.id.primerNumero);
        segundo = findViewById(R.id.segundoNumero);
        tercero = findViewById(R.id.tercerNumero);
    }//Fin onCreate

    public void numeroMenor(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Resultado: ");

        num1=Integer.parseInt(primero.getText().toString());
        num2=Integer.parseInt(segundo.getText().toString());
        num3=Integer.parseInt(tercero.getText().toString());

        if(num1 < num2 && num1 < num3){alert.setMessage("El "+num1+" es el menor");}
        if(num2 < num1 && num2 < num3){alert.setMessage("El "+num2+" es el menor");}
        if(num3 < num1 && num3 < num2){alert.setMessage("El "+num3+" es el menor");}
        alert.show();
    }

    public void numeroMayor(View v){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Resultado: ");

        num1=Integer.parseInt(primero.getText().toString());
        num2=Integer.parseInt(segundo.getText().toString());
        num3=Integer.parseInt(tercero.getText().toString());

        if(num1 > num2 && num1 > num3){alert.setMessage("El "+num1+" es el mayor");}
        if(num2 > num1 && num2 > num3){alert.setMessage("El "+num2+" es el mayor");}
        if(num3 > num1 && num3 > num2){alert.setMessage("El "+num3+" es el mayor");}
        alert.show();
    }
}//Fin clase
