package mx.edu.ittepic.tpdm_ejercicio2_rebotarcirculo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class Lienzo extends View {

    private Circulo circulos[];
    private int maxX, maxY;

    public Lienzo(Context context, int nCirculos){
        super(context);

        circulos = new Circulo[nCirculos];

        for(int i = 0; i < circulos.length; i++){
            Random random = new Random();

            circulos[i] = new Circulo(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            circulos[i].ponerCoordenadas((int) (Math.random()*400) + 1,(int) (Math.random()*400) + 1, (int) (Math.random()*300) + 100);
            circulos[i].setSpeed((int) Math.random()*20 + 10,(int) Math.random()*20 + 10);
        }
    }//Fin constructor

    @Override
    protected void onSizeChanged(int w, int h, int viejoW, int viejoH){
        super.onSizeChanged(w,h,viejoW, viejoH);
        maxX = w;
        maxY = h;
        for(int i=0; i < circulos.length; i++)
            circulos[i].setMax(maxX, maxY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < circulos.length; i++){
            circulos[i].dibujar(canvas);
        }


        invalidate();
    }
}
