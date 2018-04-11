package mx.edu.ittepic.tpdmu2_2;


import android.app.AlertDialog;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento2 extends Fragment {


    public Fragmento2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragmento2, container, false);
    }
    //x es un cursor
   /* private void hacerSelect(){
        try {
            String[] datos = new String[x.getCount()];
            int i = 0;
            do {
                datos[i] = x.getString(1);
                i++;
            } while (x.moveToNext);

            base.close();
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.activity_list_item, datos);
            lista.setAdapter(adaptador);
        }catch (SQLiteException e){
            AlertDialog.Builder a = new AlertDialog.Builder(getContext());
            a.setMessage(e.getMessage()).show();
        }
    }*/

}
