package mx.edu.ittepic.practicau1_12_vectorparametro_brianalejandrocasaslopez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtVector;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVector = findViewById(R.id.txtVector);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buscarIndice = new Intent(getApplicationContext(), BuscarIndice.class);
                buscarIndice.putExtra("vector",txtVector.getText().toString());
                startActivity(buscarIndice);
            }
        });
    }//Fin de onCreate
}
