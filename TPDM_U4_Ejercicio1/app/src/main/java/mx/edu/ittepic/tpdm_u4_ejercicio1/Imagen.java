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
                                                //Funcion de tipo comportamiento
        int x2 = x+img.getWidth();
        int y2 = y+img.getHeight();

        if(xp >= x && xp <= x2){
            if(yp >= y && yp <= y2){
                return true;
            }
        }
        return true;
    }//Fin estaEnArea

    public void mover(float x, float y){
        this.x = (int) x- img.getWidth()/2;
        this.y = (int) y -img.getHeight()/2;
    }//Fin mover

    public boolean estaEnColision(Imagen otroObjeto){
        int x2DelOtroObjeto = otroObjeto.x+otroObjeto.img.getWidth();
        int y2DelOtroObjeto = otroObjeto.y+otroObjeto.img.getHeight();

        if(estaEnArea(otroObjeto.x, otroObjeto.y))
            return true;

        if(estaEnArea(x2DelOtroObjeto, otroObjeto.y))
            return true;

        if(estaEnArea(otroObjeto.x, y2DelOtroObjeto))
            return true;

        if(estaEnArea(x2DelOtroObjeto, y2DelOtroObjeto))
            return true;

        return false;
    }//Fin estaEnColision

}//Fin clase

/*if(e.getX() >= posXimagen && e.getX() <= posXimagen+imagen.getWidth()){
                    if(e.getY() >= posYimagen && e.getY() <= posYimagen+imagen.getHeight()){
                        posXimagen = (int) e.getX() - imagen.getWidth()/2;
                        posYimagen = (int) e.getY()- imagen.getHeight()/2;
                        return true;
                    }
                }//fin if*/