package mx.edu.ittepic.practicau1_5_activitys_brianalejandrocasaslopez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Practica1_5 extends AppCompatActivity {

    ListView listaMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica1_5);

        listaMenu = findViewById(R.id.listMenu);
        listaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int numeroItemSeleccionado, long l) {
                switch (numeroItemSeleccionado){
                    case 0:
                        Intent suma = new Intent(getApplicationContext(), Suma.class);
                        startActivity(suma);
                        break;
                    case 1:
                        Intent concatenar = new Intent(getApplicationContext(), Concatenar.class);
                        startActivity(concatenar);
                        break;
                    case 2:
                        Intent guardarArchivo = new Intent(getApplicationContext(), GuardarArchivo.class);
                        startActivity(guardarArchivo);
                        break;
                    case 3:
                       // Intent guardarArchivo = new Intent(getApplicationContext(), GuardarArchivo.class);
                       // startActivity(guardarArchivo);
                        break;
                    default:
                        finish();
                }//Fin de switch
            }
        });
    }//Fin de on create
}//Fin clase
