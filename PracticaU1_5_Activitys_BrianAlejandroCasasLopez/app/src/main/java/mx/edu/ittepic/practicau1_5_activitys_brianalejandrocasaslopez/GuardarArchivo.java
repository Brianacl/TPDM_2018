package mx.edu.ittepic.practicau1_5_activitys_brianalejandrocasaslopez;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class GuardarArchivo extends AppCompatActivity {

    EditText mensaje;
    Button btnGuardar;

    String nombreArchivo = "constante";
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_archivo);

        mensaje = findViewById(R.id.escribirMensaje);
        btnGuardar = findViewById(R.id.guardarArchivo);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(null, "Presionaste el botón", Toast.LENGTH_SHORT);
                guardarTexto();
            }//Fin de onClick
        });
    }//Fin de onCreate

    private void guardarTexto(){
        try
        {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            openFileOutput("constante.txt", Context.MODE_PRIVATE));

            fout.write(mensaje.getText().toString());
            fout.close();
            Toast.makeText(this, "Se guardó correctamente", Toast.LENGTH_LONG);
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }
}//Fin de clase
