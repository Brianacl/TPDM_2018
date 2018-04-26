package mx.edu.ittepic.tpdm_ejercicio2_rebotarcirculo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;

public class Circulo {
    private int izquierdoTopX;
    private int izquierdoTopY;
    public int radio;
    private Paint paint;
    private RectF circulo;

    private int speedX;
    private int speedY;

    private int maxX;
    private int maxY;

    public Circulo(int color){
        paint = new Paint();
        paint.setColor(color);
        circulo = new RectF();
    }//Fin constructor

    public void ponerCoordenadas(int x, int y, int radio){
        izquierdoTopX = x;
        izquierdoTopY = y;
        this.radio = radio;
        circulo.set(izquierdoTopX, izquierdoTopY,
                izquierdoTopX+this.radio*2, izquierdoTopY+this.radio*2);
    }

    public void dibujar(Canvas canvas){
        canvas.drawOval(circulo,paint);
        redibujar();
    }

    public void redibujar(){
        if(izquierdoTopX + 2 * radio > maxX){
            speedX = speedX * -1;
        }else if (izquierdoTopX < 0){
            speedX = speedX * -1;
        }

        if(izquierdoTopY + 2 * radio > maxY){
            speedY = speedY * -1;
        }else if (izquierdoTopY < 0){
            speedY = speedY * -1;
        }

        izquierdoTopX = izquierdoTopX + speedX;
        izquierdoTopY = izquierdoTopY + speedY;

        circulo.set(izquierdoTopX, izquierdoTopY,
                izquierdoTopX+2 * radio, izquierdoTopY+2*radio);
    }//Fin redibujar

    public void setMax(int maxX, int maxY){
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void setSpeed(int speedX, int speedY){
        this.speedX = speedX;
        this.speedY = speedY;
    }
}
