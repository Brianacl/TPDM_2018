package mx.edu.ittepic.miniu1_brianalejandrocasaslopez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuPrincipal extends AppCompatActivity {

    ImageButton btnNotificacion, btnInfoEscolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnNotificacion = findViewById(R.id.notificacion);
        btnInfoEscolar = findViewById(R.id.infoEscolar);

        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificaciones = new Intent(MenuPrincipal.this,notificaciones.class);
                startActivity(notificaciones);
            }
        });

        btnInfoEscolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoEscolar = new Intent(MenuPrincipal.this,noticias.class);
                startActivity(infoEscolar);
            }
        });
    }
}
