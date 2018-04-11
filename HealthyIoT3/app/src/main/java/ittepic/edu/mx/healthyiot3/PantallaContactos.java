package ittepic.edu.mx.healthyiot3;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PantallaContactos extends AppCompatActivity {
    EditText txtNombreApodo;
    EditText txtTeleono;
    Conexion conexion;
    Button guardarContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_contactos);

        txtNombreApodo = (EditText) findViewById(R.id.txtNombreApodo);
        txtTeleono = (EditText) findViewById(R.id.txtTelefono);
        guardarContacto = (Button) findViewById(R.id.btnGuardarContacto);

        conexion = new Conexion(this,"HealthyIoT", null, 1);
        guardarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarMisDatos();
            }
        });
    }

    private void insertarMisDatos() {
        String nombre = txtNombreApodo.getText().toString();
        String telefono = txtTeleono.getText().toString();
        try{
            SQLiteDatabase db = conexion.getWritableDatabase();
            String SQL = "INSERT INTO CONTACTOS(NOMBRECONTACTO, TELEFONO) VALUES('"+nombre+"','"+telefono+"')";
            db.execSQL(SQL);
            db.close();
            txtNombreApodo.setText("");
            txtTeleono.setText("");
            Toast.makeText(this, "El contacto se ha guardado", Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Toast.makeText(this, "Llene los dos campos", Toast.LENGTH_LONG).show();
        }//FIN CATCH
    }
}
