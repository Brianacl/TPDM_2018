package mx.edu.ittepic.tpdm_u4_ejercicio1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View { //View necesita saber quien lo va a invocar

    CountDownTimer t;
    int desplazamientoX = 5;
    Imagen imagenes[], puntero;
    String mensaje;


    public Lienzo(Context context) {
        super(context);

        mensaje = "Sin colisión";

        t = new CountDownTimer(200000,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                desplazamientoX += 5;
                invalidate();
            }

            @Override
            public void onFinish() {

            }
        };

        t.start();
        //imagen = new Imagen(BitmapFactory.decodeResource(getResources(),  R.drawable.link), 50, 500);

        //imagen2 = new Imagen(BitmapFactory.decodeResource(getResources(), R.drawable.cascomc), 100,250);

        int nombreArchivos[] = {R.drawable.androiduno,
                R.drawable.androiddos,
                R.drawable.androidtres,
                R.drawable.androidcuatro,
                R.drawable.androidcinco,
                R.drawable.link};

        int coorx[] = {200, 300, 400, 500, 660, 790};
        int coory[] = {200, 300, 400, 500, 660, 790};

        imagenes = new Imagen[6];


        for(int i=0; i<imagenes.length; i++){
            imagenes[i] = new Imagen(BitmapFactory.decodeResource
                    (getResources(), nombreArchivos[i]), coorx[i], coory[i]);
        }//Fin for

        puntero = null; //Va a dirigirse a imagen 1 o imagen 2 y es el que va a hacer el arrastre

    }//Fin constructor

    protected void onDraw(Canvas c){
        Paint p = new Paint();

        p.setColor(Color.LTGRAY);

        p.setTextSize(60);
        p.setColor(Color.RED);

        c.drawText("(C) Brian Alejandro Casas López", 100,200, p);

        p.setColor(Color.BLUE);
        c.drawOval(150 + desplazamientoX,300, 300 + desplazamientoX, 450, p);

        //c.drawBitmap(imagen.img, imagen.x, imagen.y, p);
        for(int i=0; i<imagenes.length;i++){
            c.drawBitmap(imagenes[i].img, imagenes[i].x, imagenes[i].y, p);
        }//Fin for

        c.drawText(mensaje, 50, 50, p);

    }//Fin de onDraw

    public boolean onTouchEvent(MotionEvent e){
        //TODO e.getAction(); Nos dice si se presiono, se movio o se solto
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                //programas el estado "PRESIONADO"
                for(int i = 0; i<imagenes.length;i++) {
                    if (imagenes[i].estaEnArea((int) e.getX(), (int) e.getY())) {
                        puntero = imagenes[i];
                        i = imagenes.length;
                        //break; cualquiera de las dos opciones está bien
                    }
                }//Fin for
                break;
            case MotionEvent.ACTION_MOVE:
                //Programa el estado "ARRASTRE"
                if(puntero == null) return true;

                puntero.mover(e.getX(), e.getY());
                mensaje = "Sin colisión";

                /*if(imagen.estaEnColision(imagen2)){
                    mensaje = "COLISIONO A CON B";
                }*/

                break;
            case MotionEvent.ACTION_UP:
                //Programa el estado "SOLTAR"
                puntero = null;
                break;
        }//fin switch
        return true;
    }//Fin onTouchEvent

}//Fin clase
