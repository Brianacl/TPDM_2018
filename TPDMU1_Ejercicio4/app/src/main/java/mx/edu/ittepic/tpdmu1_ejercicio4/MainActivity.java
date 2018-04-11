package mx.edu.ittepic.tpdmu1_ejercicio4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView etiqueta;
    ToggleButton botonEstado;
    CheckBox casillaverificacion;
    RadioButton radio1, radio2;
    CheckedTextView etiquetaCasillaVerificacion;
    ProgressBar progressBar;
    RatingBar ratingBar;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiqueta = findViewById(R.id.textView);
        btn = findViewById(R.id.button1);
        botonEstado = findViewById(R.id.toggleButton);
        casillaverificacion = findViewById(R.id.checkBox);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        etiquetaCasillaVerificacion = findViewById(R.id.checkedText);
        progressBar = findViewById(R.id.progressBar);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);

        etiqueta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click en etiqueta", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click en botón", Toast.LENGTH_SHORT).show();
                progressBar.setProgress(progressBar.getProgress()+30);
            }
        });

        botonEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ESTADO: "+botonEstado.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        casillaverificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ESTADO: "+ casillaverificacion.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ESTADO RADIO1: "+ radio1.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ESTADO RADIO2: "+ radio2.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        etiquetaCasillaVerificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Casilla de verificación ", Toast.LENGTH_SHORT).show();
                    }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Se ejecuta cuando mueves el SELECTOR (bolita de la barra)
                Toast.makeText(MainActivity.this, "PROGRESO: "+i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Cuando inicias ARRASTRE del selector
                Toast.makeText(MainActivity.this, "INICIANDO", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Cuando terminas de ARRASTRE del selector}
                Toast.makeText(MainActivity.this, "FINALIZANDO", Toast.LENGTH_SHORT).show();
            }
        });
    }//Fin de onCreate
}//Fin clase
