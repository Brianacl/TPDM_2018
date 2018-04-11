package ittepic.edu.mx.tap_33_4;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;

public class ActivityMateria extends AppCompatActivity {
    EditText txtnombreMateria;
    EditText txtcreditos;
    Button btnguardar;
    Conexion conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);

        txtnombreMateria =(EditText) findViewById(R.id.editText4);
        txtcreditos = (EditText) findViewById(R.id.editText5);

        btnguardar = (Button) findViewById(R.id.button2);
        conexion = new Conexion(this,"SiiDB", null, 1);
        //CREAR EL METODO CONEXION
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertaMateria();
            }
        });
    }

    private void insertaMateria() {
        //MÉTODO PARA INSERTAR MATERIAS EN LA BASE DE DATOS
        String nombremATERIA = txtnombreMateria.getText().toString();
        String creditos = txtcreditos.getText().toString();
        try{
            SQLiteDatabase db = conexion.getWritableDatabase();
            String SQL = "INSERT INTO MATERIA(NOMBREMATERIA, CREDITOS) VALUES('"+nombremATERIA+"',"+creditos+")";
            db.execSQL(SQL);
            db.close();
            txtnombreMateria.setText("");
            txtcreditos.setText("");
            Toast.makeText(this, "La materia se ha registrado correctamente.", Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Toast.makeText(this, "Error al conectar con la base de datos.", Toast.LENGTH_LONG).show();
        }//FIN CATCH
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menupantallas, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.idAlumnos:
                Intent i = new Intent(ActivityMateria.this,ActivityAlumnos.class);
                startActivity(i);
                return true;
            case R.id.idSalirApp:
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
            case R.id.idBoleta:
                Intent l = new Intent(ActivityMateria.this, ActivityBoleta.class);
                startActivity(l);
                return true;
            case R.id.idMaterias:
                Intent m = new Intent(ActivityMateria.this, ActivityMateria.class);
                startActivity(m);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
