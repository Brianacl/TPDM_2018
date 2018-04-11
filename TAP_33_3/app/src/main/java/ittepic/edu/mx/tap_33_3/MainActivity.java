package ittepic.edu.mx.tap_33_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imagen1;
    int  noImagen= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RELACIONAR CON XML
        imagen1 = (ImageView) findViewById(R.id.imageView);

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metodoImagen();
            }
        });
    }

    public void metodoImagen(){
        noImagen++;
         switch(noImagen){
             case 1:
                 imagen1.setImageResource(R.drawable.corazon);
                 break;
             case 2:
                 imagen1.setImageResource(R.drawable.guardar);
                 break;
             case 3:
                 imagen1.setImageResource(R.drawable.titulo);
                 break;
             case 4:
                 imagen1.setImageResource(R.drawable.ajustes);
                 noImagen = 0;
                 break;
         }
    }
}
