package mx.edu.ittepic.tpdm_ejercicio2_rebotarcirculo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialog;
    private EditText cantidadCirculos;
    private int nCirculos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cantidadCirculos = new EditText(this);
        cantidadCirculos.setInputType(InputType.TYPE_CLASS_NUMBER);

        dialog = new AlertDialog.Builder(this);

        dialog.setView(cantidadCirculos);
        dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cantidadCirculos.getText().length()>0) {
                    nCirculos = Integer.parseInt(cantidadCirculos.getText().toString());
                }else
                    nCirculos = 0;
                llamarLienzo();
            }
        });
        dialog.setMessage("¿Cuántos circulos desea?").setTitle("PROVEMOS CANVAS!").show();

    }

    protected void llamarLienzo(){
        if(nCirculos > 0){
            setContentView(new Lienzo(this, nCirculos));
        }
        else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            cantidadCirculos = new EditText(this);
            cantidadCirculos.setInputType(InputType.TYPE_CLASS_NUMBER);
            dialog.setView(cantidadCirculos);
            dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(cantidadCirculos.getText().length()>0) {
                        nCirculos = Integer.parseInt(cantidadCirculos.getText().toString());
                    }else
                        nCirculos = 0;
                    llamarLienzo();
                }
            });
            dialog.setMessage("¿Cuántos circulos desea?").setTitle("DEBEN SER MINIMO 1").show();
        }
    }
}
