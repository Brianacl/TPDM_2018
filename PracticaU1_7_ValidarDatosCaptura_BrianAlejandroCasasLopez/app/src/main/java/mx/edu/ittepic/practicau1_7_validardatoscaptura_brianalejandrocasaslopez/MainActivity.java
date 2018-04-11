package mx.edu.ittepic.practicau1_7_validardatoscaptura_brianalejandrocasaslopez;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button btnValidar;
    RadioButton rbtnHombre, rbtnMujer;
    EditText nombre, domicilio, edad;
    Switch estadoCivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValidar = findViewById(R.id.btnValidar);
        rbtnHombre = findViewById(R.id.rbtnHombre);
        rbtnMujer = findViewById(R.id.rbtnMujer);
        nombre = findViewById(R.id.nombre);
        domicilio = findViewById(R.id.domicilio);
        edad = findViewById(R.id.edad);
        estadoCivil = findViewById(R.id.interruptor);

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar(nombre.getText().toString(), domicilio.getText().toString(), edad.getText().toString());
            }
        });

    }//Fin onCreate

    protected boolean validar(String nombre, String domicilio, String edad){
        int edad_entero = 0;
        if(edad.length() != 0){edad_entero = Integer.parseInt(edad);}

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Validación de datos");

        if(nombre.length() < 3){
            alert.setMessage("Falta tu nombre");
            alert.show();
            return false;
        }

        if(domicilio.length() < 3){
            alert.setMessage("Falta tu domicilio");
            alert.show();
            return false;
        }

        if(edad.length() < 1){
            alert.setMessage("Falta tu edad");
            alert.show();
            return false;
        }

        if(edad_entero < 1){
            alert.setMessage("Tu edad no puede ser cero o menor");
            alert.show();
            return false;
        }

        if(!rbtnMujer.isChecked() && !rbtnHombre.isChecked()){
            alert.setMessage("Falta elegir tu sexo.");
            alert.show();
            return false;
        }

        alert.setMessage("Felicidades, has aprobado el curso.");
        alert.show();   
        return true;
    }

}//Fin clase
