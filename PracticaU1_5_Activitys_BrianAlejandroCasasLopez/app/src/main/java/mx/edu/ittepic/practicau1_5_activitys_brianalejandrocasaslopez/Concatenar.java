package mx.edu.ittepic.practicau1_5_activitys_brianalejandrocasaslopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Concatenar extends AppCompatActivity {

    EditText primerMensaje, segundoMensaje;
    TextView mensajeFinal;
    Button concatenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concatenar);

        primerMensaje = findViewById(R.id.primerMensaje);
        segundoMensaje = findViewById(R.id.segundoMensaje);
        mensajeFinal = findViewById(R.id.mensajeFinal);
        concatenar = findViewById(R.id.concatenar);

        concatenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mensajeFinal.setText(primerMensaje.getText().toString()+" "+segundoMensaje.getText().toString());
            }
        });
    }
}
