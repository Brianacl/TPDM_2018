package mx.edu.ittepic.tpdm_u3_ejercicio2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by titab on 20/03/2018.
 */

public class Generador extends AsyncTask<Integer, Void, String> {

    MainActivity puntero; //Apuntará a una mainActivity
    ProgressDialog dialogo;

    public Generador(MainActivity p){ //p trae la dirección del activity
        puntero = p;
        dialogo = ProgressDialog.show(puntero, "Atención", "Generando números");
    }

    protected void onPreExecute(){
        //Se manda llamar ANTES del doInBackground
    }

    @Override
    protected String doInBackground(Integer... enteros) { //EL TIPO QUE DEVUELVE DEPENDE DEL TIPO 3 DE LA CLASE
                                                     //MANEGAR CON DATOS TIPO CLASE, NO PRIMITIVOS
        //Los tres puntos es igual a []. Es un arreglo pues
        //TODO ESTE ES EL CODIGO QUE SE EJECUTARA EN 2DO PLANO DE MANERA ASINCRONA

        String resultado ="";

        for(int i=1; i<=enteros[0]; i++){
            resultado += " " + (int)(Math.random()*enteros[1]);
        }

        return resultado;
    }//fin doInBackground

    protected void onPostExecute(String res){
        //Tras la ejecución del doInBackground se llama al POSTEXECUTE
        dialogo.dismiss();

        AlertDialog.Builder alerta = new AlertDialog.Builder(puntero);
        alerta.setTitle("RESULTADO").setMessage(res).show();
        //Log.e("RESULTADO", res);
    }//fin onPostExecute

}//Fin clase
