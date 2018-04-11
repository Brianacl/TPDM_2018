package mx.edu.ittepic.tpdmu2_ejercicio1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText celular, contraseña;
    Button btninscribir;
    BaseDatos dbms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbms = new BaseDatos(this, "LOGIN", null, 1);
        celular = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.password);
        btninscribir = findViewById(R.id.btninscribir);

        btninscribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inscribirUsuario();
            }
        });
    }//Fin de onCreate

    private void inscribirUsuario(){
        try{
            SQLiteDatabase db = dbms.getReadableDatabase(); //INSERT, DELETE O UPDATE
            //Hay dos metodos para hacer el insert normal y {nueva}
           // String SQL = "INSERT INTO USUARIO VALUES(NULL,'"+celular.getText().toString()+"','"+contraseña.getText().toString()+"')"; //Con valores incrementales vamos a poner NULL en el campo correspondiente
            String SQL = "INSERT INTO USUARIO VALUES(NULL,'{CELULAR}','{CONTRASENA}')";
            SQL = SQL.replace("{CELULAR}", celular.getText().toString());
            SQL = SQL.replace("{CONTRASENA}", contraseña.getText().toString());

            db.execSQL(SQL); //SE EJECUTA EL INSERT DENTRO DE LA BASE DE DATOS "LOGIN"
            db.close();  //Cierra la conexión a la BD

            celular.setText("");
            contraseña.setText("");
            Toast.makeText(this, "SE INSCRIBIO CORRECTAMENTE", Toast.LENGTH_LONG).show();
        }catch(SQLiteException e){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("ATENCIÓN!");
            alerta.setMessage("ERROR: "+ e.getMessage());
            alerta.show();
        }
    }//Fin de inscribirUsuario

}//Fin de clase
