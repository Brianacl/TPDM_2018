package ittepic.edu.mx.healthyiot3;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosUsuario extends AppCompatActivity {
    EditText nombre, edad, peso, correo, enfermedadCronica;
    Button guardarMisDatos;
    Conexion conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        nombre = (EditText) findViewById(R.id.txtNombre);
        edad = (EditText) findViewById(R.id.txtEdad);
        peso = (EditText) findViewById(R.id.txtPeso);
        correo = (EditText) findViewById(R.id.txtCorreo);
        enfermedadCronica = (EditText) findViewById(R.id.txtCronica);

        guardarMisDatos = (Button) findViewById(R.id.btnMisDatos);
        conexion = new Conexion(this,"HealthyIoT", null, 1);
        guardarMisDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMisDatos();
            }
        });
    }

    private void insertarMisDatos() {
        //MÉTODO PARA INSERTAR MATERIAS EN LA BASE DE DATOS
        String nombre = this.nombre.getText().toString();
        String edad = this.edad.getText().toString();
        String peso = this.peso.getText().toString();
        String correo = this.correo.getText().toString();
        String enfermedades = this.enfermedadCronica.getText().toString();
        try{
            SQLiteDatabase db = conexion.getWritableDatabase();
            String SQL = "INSERT INTO USUARIO(NOMBRE,EDAD,PESO,CORREO,EN_CRONICAS) VALUES('"+nombre+"',"+edad+","+peso+",'"+correo+"','"+enfermedades+"')";
            db.execSQL(SQL);
            db.close();
           this.nombre.setText("");
            this.edad.setText("");
            this.peso.setText("");
            this.correo.setText("");
            this.enfermedadCronica.setText("");
            Toast.makeText(this, "Tus datos se han guardado", Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Toast.makeText(this, "Error al conectar con la base de datos.", Toast.LENGTH_LONG).show();
        }//FIN CATCH
    }
}
