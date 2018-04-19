package mx.edu.ittepic.tpdm_u4_ejercicio1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View { //View necesita saber quien lo va a invocar

    CountDownTimer t;
    int desplazamientoX = 5;
    Bitmap imagen, imagen2, imagen3, imagen4;
    int posXimagen, posYimagen;
    int posXimagen2, posYimagen2;

    public Lienzo(Context context) {
        super(context);

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
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.link);
        imagen2 = BitmapFactory.decodeResource(getResources(), R.drawable.cascomc);

        posXimagen = 50;
        posYimagen = 500;

        posXimagen = 100;
        posYimagen = 250;
    }//Fin constructor

    protected void onDraw(Canvas c){
        Paint p = new Paint();
        p.setTextSize(60);
        p.setColor(Color.RED);

        c.drawText("(C) Brian Alejandro Casas López", 100,200, p);

        p.setColor(Color.BLUE);
        c.drawOval(150 + desplazamientoX,300, 300 + desplazamientoX, 450, p);

        c.drawBitmap(imagen, posXimagen, posYimagen, p);
        c.drawBitmap(imagen2, 100, 200, p);
    }//Fin de onDraw

    public boolean onTouchEvent(MotionEvent e){
        //TODO e.getAction(); Nos dice si se presiono, se movio o se solto
        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                //programas el estado "PRESIONADO"
                break;
            case MotionEvent.ACTION_MOVE:
                //Programa el estado "ARRASTRE"
                if(e.getX() >= posXimagen && e.getX() <= posXimagen+imagen.getWidth()){
                    if(e.getY() >= posYimagen && e.getY() <= posYimagen+imagen.getHeight()){
                        posXimagen = (int) e.getX() - imagen.getWidth()/2;
                        posYimagen = (int) e.getY()- imagen.getHeight()/2;
                        return true;
                    }
                }//fin if

                if(e.getX() >= posXimagen2 && e.getX() <= posXimagen2+imagen2.getWidth()){
                    if(e.getY() >= posYimagen2 && e.getY() <= posYimagen2+imagen2.getHeight()){
                        posXimagen2 = (int) e.getX() - imagen2.getWidth()/2;
                        posYimagen2 = (int) e.getY()- imagen2.getHeight()/2;
                    }
                }//fin if
                break;
            case MotionEvent.ACTION_UP:
                //Programa el estado "SOLTAR"
                break;
        }//fin switch
        return true;
    }//Fin onTouchEvent

}//Fin clase
