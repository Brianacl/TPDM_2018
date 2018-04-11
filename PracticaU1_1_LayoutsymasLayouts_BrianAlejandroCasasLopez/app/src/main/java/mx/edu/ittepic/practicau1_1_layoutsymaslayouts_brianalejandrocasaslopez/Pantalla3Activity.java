package mx.edu.ittepic.practicau1_1_layoutsymaslayouts_brianalejandrocasaslopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Pantalla3Activity extends AppCompatActivity {

    Spinner spinner, spinnerCargo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla3);

        spinner = findViewById(R.id.spinner);
        spinnerCargo = findViewById(R.id.spinnerCargo);
        String[] opciones = {"Soltero","Casado","Viudo","Divorciado"};
        String[] opcionesCargo = {"Ventas","Informatica", "Jardinería"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones));
        spinnerCargo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesCargo));
    }
}
