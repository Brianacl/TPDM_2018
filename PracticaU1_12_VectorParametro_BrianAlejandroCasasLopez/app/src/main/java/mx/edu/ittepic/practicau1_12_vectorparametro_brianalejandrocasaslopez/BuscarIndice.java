package mx.edu.ittepic.practicau1_12_vectorparametro_brianalejandrocasaslopez;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuscarIndice extends AppCompatActivity {

    EditText txtPosicion;
    Button btnMostrar;
    TextView viewResultado, viewPosicion;

    String vector[];
    AlertDialog.Builder alert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_indice);

        txtPosicion = findViewById(R.id.txtPosicion);
        btnMostrar = findViewById(R.id.btnMostrar);
        viewResultado = findViewById(R.id.resultado);
        viewPosicion = findViewById(R.id.viewPosicion);
        alert = new AlertDialog.Builder(this);

        vector = getIntent().getStringExtra("vector").split(",");

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    viewResultado.setText(vector[Integer.parseInt(txtPosicion.getText().toString())]);
                    viewPosicion.setText("Posición " + txtPosicion.getText().toString() + ":");
                }catch (ArrayIndexOutOfBoundsException ex){
                    alert.setTitle("ERROR");
                    alert.setMessage("No existe esta posición en el vector");
                    alert.show();
                }
            }
        });
    }//Fin de onCreate
}
