package mx.edu.ittepic.tpdm_u3_ejercicio3;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by titab on 21/03/2018.
 */

public class ConexionWeb extends AsyncTask<URL, String, String> {

    List<String[]> variables;
    MainActivity puntero;

    public ConexionWeb(MainActivity direccionActivity){
        puntero = direccionActivity;
        variables = new ArrayList<String[]>();
    }//Fin ConexionWeb

    public void agregarVariable(String nombre, String contenido){
        //String[] temporal = {nombre, contenido};

        String[] temporal = new String[2];
        temporal[0] = nombre;
        temporal[1] = contenido;

        variables.add(temporal);
    }//fin agregarVariable

    @Override
    protected String doInBackground(URL... urls) {
        String POST="";
        String respuesta="";

        for(int i=0; i < variables.size(); i++){
            String[] temporal = variables.get(i);
            Log.v("--> ",temporal[0]+"="+ temporal[1]);

            try{
                POST+= temporal[0]+"="+ URLEncoder.encode(temporal[1], "UTF-8")+" ";
                Log.v("--> ",POST);
            }catch(Exception e){
                return "ERROR_404_0";
            }
        }//Fin for

        POST = POST.trim();
        POST = POST.replace(" ","&");
        Log.v("--> ",POST);

        HttpURLConnection conexion = null;

        try{
            publishProgress("Intentando conectar");
            conexion = (HttpURLConnection) urls[0].openConnection(); //Se conectó al servidor

            conexion.setDoInput(true);
            conexion.setFixedLengthStreamingMode(POST.length()); //Cantidad de bytes que va a mandar
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

            publishProgress("Recuperando respueta del servidor");

            OutputStream flujoSalida = new BufferedOutputStream(conexion.getOutputStream());
            flujoSalida.write(POST.getBytes()); //TODO Como se envía a través de la red debe enviarse en formato de red
                                                //TODO esto ayuda al entendimiento entre S.O.
            flujoSalida.flush(); //Envía el resultado y recibe un resultado 200 para correcto y diferente para errores
            flujoSalida.close();

            if(conexion.getResponseCode() == 200){
                InputStreamReader input = new InputStreamReader(conexion.getInputStream(),"UTF-8");

                BufferedReader flujoEntrada = new BufferedReader(input);  //Lee una línea completa
                String linea= "";

                do {
                    linea = flujoEntrada.readLine();
                    if(linea!=null){
                        respuesta += linea;
                        Log.v("--> ", respuesta);
                    }
                }while(linea != null);
                flujoEntrada.close();
            }else{
                return "ERROR_404_1"; //Aquí puede ser el error que sea, significa que fallo TODO flujo de salida
            }                           //no se puede saber si fallo el evio o al recibir datos
        }catch(UnknownHostException e){
            return "ERROR_2";
        }catch(IOException e){

        }finally {
            if(conexion != null){
                conexion.disconnect();
            }
        }//fin de finally
        /*
         1. Generar la cadena de envio de variables
         2. Conectarse al servidor
         3. Envía mediante POST la cadena de variables ya generada
         4. Recibe la respuesta del código PHP
         5. Muestra (sirva y disfrute)
         */

        return respuesta;
    }

    protected void onProgressUpdate(String... r){
        puntero.cambiarMensaje(r[0]);
    }

    protected void onPostExecute(String respuesta){
        puntero.procesarRespuesta(respuesta);
    }//fin de onPostExecute
}//Fin de clase
