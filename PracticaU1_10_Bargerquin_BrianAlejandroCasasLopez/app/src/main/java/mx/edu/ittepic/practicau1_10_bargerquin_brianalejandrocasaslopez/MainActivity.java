package mx.edu.ittepic.practicau1_10_bargerquin_brianalejandrocasaslopez;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkItaliano, checkVegano, checkGrosero, checkRefresco;
    EditText txtItaliano, txtVegano, txtGrosero, txtRefresco;
    Button btnOrdenar;
    float total = 0;
    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert = new AlertDialog.Builder(this);

        checkItaliano = findViewById(R.id.checkItaliano);
        checkVegano = findViewById(R.id.checkVegano);
        checkGrosero = findViewById(R.id.checkGrosera);
        checkRefresco = findViewById(R.id.checkRefresco);

        txtItaliano = findViewById(R.id.txtItaliano);
        txtVegano = findViewById(R.id.txtVegano);
        txtGrosero = findViewById(R.id.txtGrosera);
        txtRefresco = findViewById(R.id.txtRefresco);

        txtItaliano.setEnabled(false);
        txtVegano.setEnabled(false);
        txtGrosero.setEnabled(false);
        txtRefresco.setEnabled(false);

        btnOrdenar = findViewById(R.id.btnOrdernar);

        checkItaliano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkItaliano.isChecked()){txtItaliano.setEnabled(true);}
                if(!checkItaliano.isChecked()){txtItaliano.setEnabled(false); txtItaliano.setText("");}
            }
        });

        checkVegano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkVegano.isChecked()){txtVegano.setEnabled(true);}
                if(!checkVegano.isChecked()){txtVegano.setEnabled(false); txtVegano.setText("");}
            }
        });

        checkGrosero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkGrosero.isChecked()){txtGrosero.setEnabled(true);}
                if(!checkGrosero.isChecked()){txtGrosero.setEnabled(false); txtGrosero.setText("");}
            }
        });

        checkRefresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkRefresco.isChecked()){txtRefresco.setEnabled(true);}
                if(!checkRefresco.isChecked()){txtRefresco.setEnabled(false); txtRefresco.setText("");}
            }
        });

        btnOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validacion()==true){
                    alert.setTitle("¡Gracias por su compra!");
                    alert.setMessage("Su total es de: $"+ total + "\nPase a ventanilla, por favor.");
                    alert.show();
                    total = 0;
                }
            }
        });
    }//Fin de onCreate


    protected boolean validacion(){
        alert.setTitle("¡Atención!");

        if(checkItaliano.isChecked() && txtItaliano.length()==0){
            alert.setMessage("Falta cantidad: Italiana");
            alert.show();
            return false;
        }
        if(checkItaliano.isChecked() && Float.parseFloat(txtItaliano.getText().toString())>0){
            total += Float.parseFloat(txtItaliano.getText().toString()) * 45;
        }

        if(checkVegano.isChecked() && txtVegano.length()==0){
            alert.setMessage("Falta cantidad: Vegana");
            alert.show();
            return false;
        }

        if(checkVegano.isChecked() && Float.parseFloat(txtVegano.getText().toString())>0){
            total += Float.parseFloat(txtVegano.getText().toString()) * 35;
        }

        if(checkGrosero.isChecked() && txtGrosero.length()==0){
            alert.setMessage("Falta cantidad: Grosera");
            alert.show();
            return false;
        }
        if(checkGrosero.isChecked() && Float.parseFloat(txtGrosero.getText().toString())>0){
            total += Float.parseFloat(txtGrosero.getText().toString()) * 55;
        }

        if(checkRefresco.isChecked() && txtRefresco.length()==0){
            alert.setMessage("Falta cantidad: Refresco");
            alert.show();
            return false;
        }
        if(checkRefresco.isChecked() && Float.parseFloat(txtRefresco.getText().toString())>0){
            total += Float.parseFloat(txtRefresco.getText().toString()) * 10;
        }

        if(!checkItaliano.isChecked() && !checkVegano.isChecked() && !checkGrosero.isChecked() && !checkRefresco.isChecked() || total == 0){
            alert.setMessage("Aún no ha ordenado nada.");
            alert.show();
            return false;
        }
        return true;
    }//Fin de validacion
}
