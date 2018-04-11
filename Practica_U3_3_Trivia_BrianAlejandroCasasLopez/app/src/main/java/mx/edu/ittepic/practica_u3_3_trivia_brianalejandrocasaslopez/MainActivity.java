package mx.edu.ittepic.practica_u3_3_trivia_brianalejandrocasaslopez;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView  intentos;
    TextView lblPregunta;
    Button btnPrimera, btnSegunda, btnTercera, btnComenzar;

    ConexionWeb conexionWeb;
    ProgressDialog progreso;
    String[] datos;
    String respuestaCorrecta;
    int totalPreguntas, puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPreguntas = 1;
        puntaje = 10;

        intentos = findViewById(R.id.esferas);
        lblPregunta = findViewById(R.id.pregunta);
        btnPrimera = findViewById(R.id.respuestaUno);
        btnSegunda = findViewById(R.id.respuestaDos);
        btnTercera = findViewById(R.id.respuestaTres);
        btnComenzar = findViewById(R.id.btnComenzar);

        btnPrimera.setEnabled(false);
        btnSegunda.setEnabled(false);
        btnTercera.setEnabled(false);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    btnComenzar.setText("¡Siguiente pregunta!");
                    conexionWeb = new ConexionWeb(MainActivity.this);
                    //conexionWeb.agregarVariables("preguntaRecibe", "-");
                    conexionWeb.agregarVariables("respuestaRecibe", "-");
                    conexionWeb.agregarVariables("respuestaCorrecta", "-");

                    //Ejecución
                    URL direccion = new URL("https://tpdm-brian.000webhostapp.com/trivia.php");
                    progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
                    conexionWeb.execute(direccion);

                    btnPrimera.setEnabled(true);
                    btnSegunda.setEnabled(true);
                    btnTercera.setEnabled(true);

                } catch (MalformedURLException malformed) {
                    Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnPrimera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    conexionWeb = new ConexionWeb(MainActivity.this);
                    //conexionWeb.agregarVariables("pregunta", lblPregunta.getText().toString());
                    conexionWeb.agregarVariables("respuestaRecibe", btnPrimera.getText().toString());
                    conexionWeb.agregarVariables("respuestaCorrecta", respuestaCorrecta);

                    //Ejecución
                    URL direccion = new URL("https://tpdm-brian.000webhostapp.com/trivia.php");
                    progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
                    conexionWeb.execute(direccion);

                    btnComenzar.setEnabled(true);
                    btnPrimera.setEnabled(false);
                    btnSegunda.setEnabled(false);
                    btnTercera.setEnabled(false);

                } catch (MalformedURLException malformed) {
                    Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    conexionWeb = new ConexionWeb(MainActivity.this);
                    conexionWeb.agregarVariables("respuestaRecibe", btnSegunda.getText().toString());
                    conexionWeb.agregarVariables("respuestaCorrecta", respuestaCorrecta);

                    //Ejecución
                    URL direccion = new URL("https://tpdm-brian.000webhostapp.com/trivia.php");
                    progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
                    conexionWeb.execute(direccion);

                    btnComenzar.setEnabled(true);
                    btnPrimera.setEnabled(false);
                    btnSegunda.setEnabled(false);
                    btnTercera.setEnabled(false);

                } catch (MalformedURLException malformed) {
                    Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnTercera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    conexionWeb = new ConexionWeb(MainActivity.this);
                    conexionWeb.agregarVariables("respuestaRecibe", btnTercera.getText().toString());
                    conexionWeb.agregarVariables("respuestaCorrecta", respuestaCorrecta);

                    //Ejecución
                    URL direccion = new URL("https://tpdm-brian.000webhostapp.com/trivia.php");
                    progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
                    conexionWeb.execute(direccion);

                    btnComenzar.setEnabled(true);
                    btnPrimera.setEnabled(false);
                    btnSegunda.setEnabled(false);
                    btnTercera.setEnabled(false);

                } catch (MalformedURLException malformed) {
                    Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
                }
            }
        });

    }//fin onCreate

    public void cambiarMensaje(String m){
        progreso.setMessage(m);
    }

    public void procesarRespuesta(String respuesta){
        //TODO COMO HACER CLASES DE LEGADO PARA PODER HACER CODIGO 100% ABSTRACTO
        progreso.dismiss();
        if(respuesta.equals("ERROR: 404_1")){
            respuesta = "Error: Flujo Entrada/Salida no funciona";
        }
        if(respuesta.equals("ERROR: 404_2")){
            respuesta = "Error: Servidor caido o dirección incorrecta";
        }

        datos = respuesta.split("-");
        if (datos.length == 4) {

            respuestaCorrecta = datos[1];

            lblPregunta.setText(datos[0]);
            btnPrimera.setText(datos[1]);
            btnSegunda.setText(datos[2]);
            btnTercera.setText(datos[3]);
            btnComenzar.setEnabled(false);
        }else {
            AlertDialog.Builder alertaMensaje = new AlertDialog.Builder(this);
            alertaMensaje.setMessage(respuesta).show();
            totalPreguntas++;
        }

        if (respuesta.equals("Ups! No es correcto")){
            puntaje--;
            if(puntaje == 9){
                intentos.setImageResource(R.drawable.esfera3);
            }
            if(puntaje == 8){
                intentos.setImageResource(R.drawable.esfera2);
            }
            if(puntaje == 7){
                intentos.setImageResource(R.drawable.esfera1);
            }
        }

        if (totalPreguntas == 10){
            AlertDialog.Builder alertaMensaje = new AlertDialog.Builder(this);
            alertaMensaje.setTitle("El juego termino!").setMessage("Tu puntaje es: "+puntaje).show();
            puntaje = 10;
            totalPreguntas = 1;
            intentos.setImageResource(R.drawable.esfera4);
            btnComenzar.setText("Nuevo juego");
        }
    }//fin procesarRespuesta

}//fin clase
