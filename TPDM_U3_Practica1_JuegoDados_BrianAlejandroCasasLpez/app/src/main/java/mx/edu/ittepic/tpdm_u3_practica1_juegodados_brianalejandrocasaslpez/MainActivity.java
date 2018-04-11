package mx.edu.ittepic.tpdm_u3_practica1_juegodados_brianalejandrocasaslpez;

import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblTurno, lblDado1, lblDado2;
    TextView lblPuntajeJ1, lblPuntajeJ2, lblPuntajeJ3, lblPuntajeJ4;
    TextView totalJ1, totalJ2, totalJ3, totalJ4;

    Button btnTirarDados;

    //Variables para datos
    int dado1 = 0, dado2 = 0, temp = 0, tempJ2=0, tempJ3=0, tempJ4=0;

    int puntaje1=0, puntaje2=0, puntaje3=0, puntaje4=0;

    Thread j1, j2, j3, j4;

    int turno=1;

    String ganador="";

    String tempString="", tempStringJ2="", tempStringJ3="", tempStringJ4="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblTurno = findViewById(R.id.lblTurno);
        lblDado1 = findViewById(R.id.lblDado1);
        lblDado2 = findViewById(R.id.lblDado2);

        lblPuntajeJ1 = findViewById(R.id.puntajeJ1);
        lblPuntajeJ2 = findViewById(R.id.puntajeJ2);
        lblPuntajeJ3 = findViewById(R.id.puntajeJ3);
        lblPuntajeJ4 = findViewById(R.id.puntajeJ4);

        totalJ1 = findViewById(R.id.totalJ1);
        totalJ2 = findViewById(R.id.totalJ2);
        totalJ3 = findViewById(R.id.totalJ3);
        totalJ4 = findViewById(R.id.totalJ4);

        btnTirarDados = findViewById(R.id.btnTirarDados);

        btnTirarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblPuntajeJ1.setText("");
                lblPuntajeJ2.setText("");
                lblPuntajeJ3.setText("");
                lblPuntajeJ4.setText("");
                puntaje1 = 0;
                puntaje2 = 0;
                puntaje3 = 0;
                puntaje4 = 0;
                tempString = "";
                tempStringJ2 = "";
                tempStringJ3 = "";
                tempStringJ4 = "";
                jugador1();
                btnTirarDados.setEnabled(false);
            }
        });
    }//Fin de onCreate

    private boolean terminoJuego(){
        if(turno < 4) {return false;}
        if(puntaje1 > puntaje2 && puntaje1 > puntaje3 && puntaje1 > puntaje4){ganador = "¡Felicidades jugador1! Tu puntaje: "+puntaje1;}
        if(puntaje2 > puntaje1 && puntaje2 > puntaje3 && puntaje2 > puntaje4){ganador = "¡Felicidades jugador2! Tu puntaje: "+puntaje2;}
        if(puntaje3 > puntaje1 && puntaje3 > puntaje2 && puntaje3 > puntaje4){ganador = "¡Felicidades jugador3! Tu puntaje: "+puntaje3;}
        if(puntaje4 > puntaje1 && puntaje4 > puntaje2 && puntaje4 > puntaje3){ganador = "¡Felicidades jugador4! Tu puntaje: "+puntaje4;}
        return true;
    }

    private void jugador1(){
        j1 = new Thread(){
            public void run(){
                while(turno < 4 && !j1.isInterrupted()){

                    try {
                        sleep(1000); //Milisegundo a dormir (hilo), esto evita que se vuelva inestable
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tirarDados();
                    puntaje1 += dado1 + dado2;
                    temp = dado1 + dado2;
                    tempString += temp +"\n";
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lblTurno.setText("Jugador 1");
                            lblDado1.setText(""+dado1);
                            lblDado2.setText(""+dado2);
                            lblPuntajeJ1.setText(tempString+"\n");
                            totalJ1.setText(puntaje1+"");
                        }
                    });
                    jugador2();
                    Thread.currentThread().interrupt();

                }//fin while
            }
        };
        j1.start();
    }//Fin jugador1

    private void jugador2() {
        j2 = new Thread(){
            public void run(){
                while (!j2.isInterrupted()){

                    try {
                        sleep(1500); //Milisegundo a dormir (hilo), esto evita que se vuelva inestable
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tirarDados();
                    puntaje2 += dado1 + dado2;
                    tempJ2 = dado1 + dado2;
                    tempStringJ2 += tempJ2 +"\n";
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lblTurno.setText("Jugador 2");
                            lblDado1.setText(""+dado1);
                            lblDado2.setText(""+dado2);
                            lblPuntajeJ2.setText(tempStringJ2+"\n");
                            totalJ2.setText(puntaje2+"");
                        }
                    });
                    jugador3();
                    Thread.currentThread().interrupt();

                }//Fin while
            }
        };
        j2.start();
    }//Fin jugador2

    private void jugador3() {
        j3 = new Thread(){
            public void run(){
                while (!j3.isInterrupted()){

                    try {
                        sleep(1500); //Milisegundo a dormir (hilo), esto evita que se vuelva inestable
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tirarDados();
                    puntaje3 += dado1 + dado2;
                    tempJ3 = dado1 + dado2;
                    tempStringJ3 += tempJ3 +"\n";
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lblTurno.setText("Jugador 3");
                            lblDado1.setText(""+dado1);
                            lblDado2.setText(""+dado2);
                            lblPuntajeJ3.setText(tempStringJ3+"\n");
                            totalJ3.setText(puntaje3+"");
                        }
                    });
                    jugador4();
                    Thread.currentThread().interrupt();

                }//Fin while
            }
        };
        j3.start();
    }//Fin jugador3

    private void jugador4() {
        j4 = new Thread(){
            public void run(){
                while (!j4.isInterrupted()){

                    try {
                        sleep(1500); //Milisegundo a dormir (hilo), esto evita que se vuelva inestable
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    tirarDados();
                    puntaje4 += dado1 + dado2;
                    tempJ4 = dado1 + dado2;
                    tempStringJ4 += tempJ4 +"\n";

                    turno ++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lblTurno.setText("Jugador 4");
                            lblDado1.setText(""+dado1);
                            lblDado2.setText(""+dado2);
                            lblPuntajeJ4.setText(tempStringJ4+"\n");
                            totalJ4.setText(puntaje4+"");

                            if(terminoJuego()){
                                AlertDialog.Builder alertaGanador = new AlertDialog.Builder(MainActivity.this);
                                alertaGanador.setTitle("TENEMOS UN GANADOR!").setMessage(ganador).show();
                                turno=1;
                                btnTirarDados.setEnabled(true);
                            }
                        }
                    });
                    jugador1();
                    Thread.currentThread().interrupt();

                }//Fin while
            }
        };
        j4.start();
    }//Fin jugador4

    private void tirarDados(){
        dado1 = (int) (Math.random() * 6 )+ 1;
        dado2 = (int) (Math.random() * 6 )+ 1;
    }
}//fin de clase
