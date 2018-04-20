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
    Imagen imagen, imagen2;


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
        imagen = new Imagen(BitmapFactory.decodeResource(getResources(), R.drawable.link));
        imagen2 = new Imagen(BitmapFactory.decodeResource(getResources(), R.drawable.cascomc));

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
                break;
            case MotionEvent.ACTION_UP:
                //Programa el estado "SOLTAR"
                break;
        }//fin switch
        return true;
    }//Fin onTouchEvent

}//Fin clase
