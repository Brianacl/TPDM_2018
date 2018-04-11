package ittepic.edu.mx.tap_33_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ActivitySII extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sii);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menupantallas, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.idAlumnos:
                Toast.makeText(this, "Ya estas ubicado en la pantalla de Alumnos", Toast.LENGTH_LONG).show();
                Intent i = new Intent(ActivitySII.this,ActivityAlumnos.class);
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
                Toast.makeText(this, "Ya estas ubicado en la pantalla de Boleta", Toast.LENGTH_LONG).show();
                Intent l = new Intent(ActivitySII.this, ActivityBoleta.class);
                startActivity(l);
                return true;
            case R.id.idMaterias:
                Toast.makeText(this, "Ya estas ubicado en la pantalla de materias", Toast.LENGTH_LONG).show();
                Intent m = new Intent(ActivitySII.this, ActivityMateria.class);
                startActivity(m);
                return true;
            case R.id.idConsultaMateria:
                Toast.makeText(this, "Ya estas ubicado en la pantalla de CONSULTA", Toast.LENGTH_LONG).show();
                Intent cm = new Intent(ActivitySII.this, Activity_consulta_materia.class);
                startActivity(cm);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//Fin del switch

    }//Fin del metodo con switch
}
