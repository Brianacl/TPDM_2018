package mx.edu.ittepic.tpdm_u4_ejercicio1;

import android.graphics.Bitmap;

public class Imagen {
    Bitmap img;

    int x, y;

    public Imagen(Bitmap i, int _x, int _y){
        img = i;
        x = _x;
        y = _y;
    }//Fin constructor

    public boolean estaEnArea(int xp, int yp){ //PUNTEROS xp y yp
        int x2 = x+img.getWidth();
        int y2 = y+img.getHeight();

        if(xp >= x && xp <= x2){
            if(yp >= y && yp <= y2){
                return true;
            }
        }
        return true;
    }

}//Fin clase

/*if(e.getX() >= posXimagen && e.getX() <= posXimagen+imagen.getWidth()){
                    if(e.getY() >= posYimagen && e.getY() <= posYimagen+imagen.getHeight()){
                        posXimagen = (int) e.getX() - imagen.getWidth()/2;
                        posYimagen = (int) e.getY()- imagen.getHeight()/2;
                        return true;
                    }
                }//fin if*/