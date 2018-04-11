package mx.edu.ittepic.tpdm_u3_ejercicio3;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button validar;
    EditText usuario, contra;
    ConexionWeb conexionWeb;
    ProgressDialog dialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.usuario);
        contra = findViewById(R.id.contra);
        validar = findViewById(R.id.validar);

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    conexionWeb = new ConexionWeb(MainActivity.this);
                    conexionWeb.agregarVariable("usuario", usuario.getText().toString());
                    conexionWeb.agregarVariable("contra", contra.getText().toString());

                    //Ejecución
                    URL direccion = new URL("https://tpdm-brian.000webhostapp.com/autenticar.php");
                    dialogo = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
                    conexionWeb.execute(direccion);
                }catch (MalformedURLException e){
                    //TOAST
                    Toast.makeText(MainActivity.this,"No se pudo contectar con el servidor",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void cambiarMensaje(String m){
        dialogo.setMessage(m);
    }

    public void procesarRespuesta(String respuesta){
        //TODO COMO HACER CLASES DE LEGADO PARA PODER HACER CODIGO 100% ABSTRACTO
        dialogo.dismiss();
        if(respuesta.equals("ERROR_404_1")){
            respuesta = "Error: Flujo Entrada/Salida no funciona";
        }
        if(respuesta.equals("ERROR_2")){
            respuesta = "Error: Servidor caido o dirección incorrecta";
        }

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Mensaje del servidor").setMessage(respuesta)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }//fin procesarRespuesta
}//Fin de clase
