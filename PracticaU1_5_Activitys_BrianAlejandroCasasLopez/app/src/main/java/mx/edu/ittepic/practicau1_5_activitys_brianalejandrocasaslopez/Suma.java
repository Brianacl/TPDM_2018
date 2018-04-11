package mx.edu.ittepic.practicau1_5_activitys_brianalejandrocasaslopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Suma extends AppCompatActivity {

    EditText editPrimero, editSegundo;
    TextView resultado;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);

        editPrimero = findViewById(R.id.primernumero);
        editSegundo = findViewById(R.id.segundonumero);
        resultado = findViewById(R.id.resultado);
        calcular = findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suma(Float.parseFloat(editPrimero.getText().toString()),Float.parseFloat(editSegundo.getText().toString()));
            }
        });

    }//FIn de on create

    protected void suma(float primero, float segundo){
        primero = primero + segundo;
        resultado.setText(primero+"");
    }//Fin de suma
}//Fin de clase
