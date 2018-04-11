package ittepic.edu.mx.healthyiot3;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class pantallaPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageButton estadoActual;
    ImageButton resumenDiario;
    ImageButton contactos;
    Button emergencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.titulocentrado);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        estadoActual = (ImageButton) findViewById(R.id.imageButtonEstado);
        resumenDiario = (ImageButton) findViewById(R.id.imageButtonResumenDiario);
        contactos = (ImageButton) findViewById(R.id.imageButtonContactos);
        emergencia = (Button) findViewById(R.id.buttonEmergencia);

        estadoActual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent estado = new Intent(pantallaPrincipal.this,EstadoActual.class);
                startActivity(estado);
            }
        });

        resumenDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resumen = new Intent(pantallaPrincipal.this,PantallaResumenDiario.class);
                startActivity(resumen);
            }
        });

        contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactosp = new Intent(pantallaPrincipal.this,PantallaContactos.class);
                startActivity(contactosp);
            }
        });
    }//FIN DEL CONTRUCTOR

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pantalla_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salir) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_misDatos) {
            Intent misDatos = new Intent(pantallaPrincipal.this,DatosUsuario.class);
            startActivity(misDatos);
        } else if (id == R.id.nav_acercaDe) {
            Intent acercaDe = new Intent(pantallaPrincipal.this,PantallaAcercaDe.class);
            startActivity(acercaDe);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
