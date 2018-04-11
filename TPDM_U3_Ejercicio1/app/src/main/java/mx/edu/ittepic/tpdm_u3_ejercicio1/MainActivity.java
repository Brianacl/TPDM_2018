package mx.edu.ittepic.tpdm_u3_ejercicio1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText numero;
    Button ciclo, hilo, timer;
    //TODO Ciclo monotarea, hilo multiproceso, timer multitarea
    CountDownTimer timercito;
    int conta, contador2;
    Thread hilito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.numero);
        ciclo = findViewById(R.id.ciclo);
        hilo = findViewById(R.id.hilo);
        timer  = findViewById(R.id.timer);

        ciclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 1; i<=10000; i++){  //TODO Está tomando el hilo principal para el solo (Parece que la aplicación está trabada)
                    numero.setText(""+i);
                }
            }
        });

        timercito = new CountDownTimer(1000000, 100) {
            //TODO: Lapso de 100 milisegundos. Cada vez que termina ejecuta el onTick
            //TODO: al primero se le resta cada vez que se acaba el lapso
            @Override
            public void onTick(long l) {
              conta++;
              setTitle(""+conta);
            }

            @Override
            public void onFinish() {

            }
        };

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Todo objeto que se ejecute en segundo plano se debe indicar que inicie con:
                //TODO: un timer no es tan fuerte como un hilo, ya que si una tarea ocupa el hilo pirncipal, la multitarea de duerme
                timercito.start();
            }
        });
                               //TODO Este es un proceso ageno al del activity (dos procesos)
        hilito = new Thread(){ //Buscará el metodo run y ejecutará lo que está ahí
            public void run(){ //El Hilo no es ciclico
                while(true){ //Se mantiene en segundo plano

                    try {
                        sleep(100); //Milisegundo a dormir (hilo), esto evita que se vuelva inestable
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    contador2++;               //Android protege que ningun programa externo a la actividad actual pueda cambiar sus
                                               //componentes graficos
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() { //todo Aquí van las lineas que cambian los componentes de tu vista y sólo eso
                            numero.setText("" + contador2);
                        }
                    });
                }
            }
        };

        hilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hilito.start();
            }
        });

    }//Fin de onCreate
}//Fin de clase
