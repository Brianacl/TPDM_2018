package mx.edu.ittepic.practica4_u3_tirotabla_brian_alejandro_casas_lopez;

import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText txtCelular, txtNombre;
    EditText txtDomicilio, txtAntiguedad;
    EditText txtSueldo, txtFechaNac;
    Button btnGuardar, btnConsulta;
    Button btnActualizar, btnEliminar;

    ConexionWeb conexionWeb;
    ProgressDialog progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCelular = findViewById(R.id.celular);
        txtNombre = findViewById(R.id.nombre);
        txtDomicilio = findViewById(R.id.domicilio);
        txtAntiguedad = findViewById(R.id.antiguedad);
        txtSueldo = findViewById(R.id.sueldo);
        txtFechaNac = findViewById(R.id.fecha);


        btnGuardar = findViewById(R.id.btnGuardar);
        btnConsulta = findViewById(R.id.btnConsultar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });
    }//Fin de onCreate

    private void guardar(){
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);

            if(txtCelular.getText().length() == 10)
            conexionWeb.agregarVariables("celular", txtCelular.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Número no valido (10 digitos, por favor)", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtNombre.getText().length()>0)
            conexionWeb.agregarVariables("nombre", txtNombre.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Nombre", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtDomicilio.getText().length()>0)
            conexionWeb.agregarVariables("domicilio", txtDomicilio.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Domicilio", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtAntiguedad.getText().length()>0)
            conexionWeb.agregarVariables("antiguedad", txtAntiguedad.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Antigüedad", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtFechaNac.getText().length()>0)
            conexionWeb.agregarVariables("fechaNac", txtFechaNac.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Fecha de nacimiento", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtSueldo.getText().length()>0)
            conexionWeb.agregarVariables("sueldo", txtSueldo.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Sueldo", Toast.LENGTH_LONG).show();
                return;
            }
            //Ejecución

            URL direccion = new URL("https://tpdm-brian.000webhostapp.com/Empleados/einsertar.php");
            progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
            conexionWeb.execute(direccion);
        }catch (MalformedURLException e){
            Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
        }
    }//Fin guardar

    private void consultar(){
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);
            if(txtCelular.getText().length()==10)
            conexionWeb.agregarVariables("celular", txtCelular.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Introduzca # valido (10 digitos, por favor)", Toast.LENGTH_LONG).show();
                return;
            }
            //Ejecución
            URL direccion = new URL("https://tpdm-brian.000webhostapp.com/Empleados/econsultarfiltrar.php");
            progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
            conexionWeb.execute(direccion);
        }catch (MalformedURLException e){
            Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
        }
    }//Fin de consultar

    private void actualizar(){
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);
            if(txtCelular.getText().length() == 10)
                conexionWeb.agregarVariables("celular", txtCelular.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Número no valido (10 digitos, por favor)", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtNombre.getText().length()>0)
                conexionWeb.agregarVariables("nombre", txtNombre.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Nombre", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtDomicilio.getText().length()>0)
                conexionWeb.agregarVariables("domicilio", txtDomicilio.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Domicilio", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtAntiguedad.getText().length()>0)
                conexionWeb.agregarVariables("antiguedad", txtAntiguedad.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Antigüedad", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtFechaNac.getText().length()>0)
                conexionWeb.agregarVariables("fechaNac", txtFechaNac.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Fecha de nacimiento", Toast.LENGTH_LONG).show();
                return;
            }

            if(txtSueldo.getText().length()>0)
                conexionWeb.agregarVariables("sueldo", txtSueldo.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Falta: Sueldo", Toast.LENGTH_LONG).show();
                return;
            }

            //Ejecución
            URL direccion = new URL("https://tpdm-brian.000webhostapp.com/Empleados/eactualizar.php");
            progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
            conexionWeb.execute(direccion);
        }catch (MalformedURLException e){
            Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
        }
    }//Fin de actualizar

    private void eliminar(){
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);

            if(txtCelular.getText().length()==10)
            conexionWeb.agregarVariables("celular", txtCelular.getText().toString());
            else {
                Toast.makeText(MainActivity.this, "Introduzca # valido (10 digitos, por favor)", Toast.LENGTH_LONG).show();
                return;
            }

            //Ejecución
            URL direccion = new URL("https://tpdm-brian.000webhostapp.com/Empleados/eliminar.php");
            progreso = ProgressDialog.show(MainActivity.this, "Atención", "Conectando con servidor");
            conexionWeb.execute(direccion);
        }catch (MalformedURLException e){
            Toast.makeText(MainActivity.this, "No se pudo contectar con el servidor", Toast.LENGTH_LONG).show();
        }
    }//Fin eliminar

    public void procesarRespuesta(String respuesta){
        AlertDialog.Builder alertaMensaje = new AlertDialog.Builder(MainActivity.this);
        if(respuesta.equals("ERROR: 404_1")){
            respuesta = "Error: Flujo Entrada/Salida no funciona";
            alertaMensaje.setTitle("ATENCIÓN!").setMessage(respuesta).show();
            return;
        }
        if(respuesta.equals("ERROR: 404_2")){
            respuesta = "Error: Servidor caido o dirección incorrecta";
            alertaMensaje.setTitle("ATENCIÓN!").setMessage(respuesta).show();
            return;
        }

        if(respuesta.equals("Se guardo correctamente!")){
            Toast.makeText(this, "Se guardo correctamente!", Toast.LENGTH_SHORT).show();
            limpiarComponentes();
            return;
        }

        if(respuesta.equals("Se eliminó el empleado")){
            Toast.makeText(this, "Se elimino el empleado", Toast.LENGTH_SHORT).show();
            txtCelular.setText("");
            return;
        }

        String datos[] = respuesta.split(",");
        txtNombre.setText(datos[1]);
        txtDomicilio.setText(datos[2]);
        txtAntiguedad.setText(datos[3]);
        txtFechaNac.setText(datos[4]);
        txtSueldo.setText(datos[5]);

    }//Fin procesarRespuesta


    private void limpiarComponentes(){
        txtNombre.setText("");
        txtDomicilio.setText("");
        txtAntiguedad.setText("");
        txtFechaNac.setText("");
        txtSueldo.setText("");
    }
}//FIn clase
