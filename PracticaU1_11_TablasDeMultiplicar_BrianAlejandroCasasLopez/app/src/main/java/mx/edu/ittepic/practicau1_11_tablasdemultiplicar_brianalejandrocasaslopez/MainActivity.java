package mx.edu.ittepic.practicau1_11_tablasdemultiplicar_brianalejandrocasaslopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    SeekBar seekBar;
    TextView txtTabla, txtHasta;
    EditText txtNumero;
    Button btnCalcular;
    int resultados = 0;
    String tabla = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        seekBar = findViewById(R.id.seekBar);
        txtHasta = findViewById(R.id.viewHasta);
        txtTabla = findViewById(R.id.viewTabla);
        txtNumero = findViewById(R.id.editText);
        btnCalcular = findViewById(R.id.btnCalcular);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtHasta.setText("Calcular hasta: "+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Intruduzca un número", Toast.LENGTH_LONG).show();
                }
                if(editText.getText().length() > 0){
                    txtTabla.setText(crearTabla(Integer.parseInt(editText.getText().toString())));
                    tabla="";
                }
            }
        });
    }//Fin de onCreate

    protected String crearTabla(int numero){
        for(int i=0; i <= seekBar.getProgress(); i++){
            resultados += numero * i;
            tabla += numero+" x "+i+" = "+resultados+"\n";
            resultados=0;
        }
        return tabla;
    }

}//Fin clase
