package mx.edu.ittepic.tpdmu2_2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento4 extends Fragment {

    EditText nombre;
    Button boton;

    public Fragmento4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento4, container, false);
        nombre = v.findViewById(R.id.nombre);
        boton = v.findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hola " + nombre.getText().toString(),  Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }

}
